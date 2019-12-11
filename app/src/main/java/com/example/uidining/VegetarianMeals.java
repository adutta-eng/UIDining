package com.example.uidining;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class VegetarianMeals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetarian_meals);
        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(unused -> {
            startActivity(new Intent(this, SelectDiningHall.class));
        });
        Intent intent = getIntent();
        connect(intent.getIntExtra("HallID", 1), intent.getStringExtra("Date"),
                intent.getStringExtra("Restriction"));
    }

    //retrieve JSON object from API and set up UI accordingly
    private void connect(int diningId, String date, String restriction){
        RequestQueue queue = Volley.newRequestQueue(this);
//        String url ="http://uiuc-api2.herokuapp.com/dining/2/2019-12-02/2019-12-02";
        String url = "https://uiuc-api2.herokuapp.com/dining/" + diningId + "/" + date + "/" + date;
        System.out.println(url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            setUpUi(response.getJSONObject("Menus"), restriction);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(this, "Oh no!", Toast.LENGTH_LONG).show();
                System.out.println("Oh no!");
            }
        });
        queue.add(jsonObjectRequest);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setUpUi(final JSONObject result, String restriction) {
        LinearLayout mealsList = findViewById(R.id.mealsList);
        TextView title = findViewById(R.id.titleMeals);
        mealsList.removeAllViews();
        try {
            JSONArray mealItemsArray = result.getJSONArray("Item");
            Gson gson = new Gson();
            List<Item> items = Arrays.asList(gson.fromJson(mealItemsArray.toString(),Item[].class));
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                Comparator<Item> cmp = Comparator.comparing(
                        Item::getMeal,
                        String.CASE_INSENSITIVE_ORDER
                );
                items.sort(cmp);
            }
            if(restriction.equals("Vegetarian")) {
                title.setText("Vegetarian Meals");
                for (Item item : items) {
                    if(item.getTraits().contains("Vegetarian")) {
//                    System.out.println(item.getFormalName());
                        View mealChunk = getLayoutInflater().inflate(R.layout.meal_chunk, mealsList, false);
                        TextView formalName = mealChunk.findViewById(R.id.formalName);
                        formalName.setText(item.getFormalName());
                        TextView meal = mealChunk.findViewById(R.id.meal);
                        meal.setText(item.getMeal());
                        Button moreInfo = mealChunk.findViewById(R.id.moreInfo);
                        mealsList.addView(mealChunk);

                    }
                }

            }

            if(restriction.equals("Gluten")) {
                title.setText("Gluten Free Meals");
                for (Item item : items) {
                    if(!item.getTraits().contains("Gluten")) {
//                    System.out.println(item.getFormalName());
                        View mealChunk = getLayoutInflater().inflate(R.layout.meal_chunk, mealsList, false);
                        TextView formalName = mealChunk.findViewById(R.id.formalName);
                        formalName.setText(item.getFormalName());
                        TextView meal = mealChunk.findViewById(R.id.meal);
                        meal.setText(item.getMeal());
                        Button moreInfo = mealChunk.findViewById(R.id.moreInfo);
                        mealsList.addView(mealChunk);

                    }
                }
            }

            if(restriction.equals("Halal")) {
                title.setText("Halal Meals");
                for (Item item : items) {
                    if(item.getTraits().contains("Halal") || item.getTraits().contains("Vegetarian")) {
//                    System.out.println(item.getFormalName());
                        View mealChunk = getLayoutInflater().inflate(R.layout.meal_chunk, mealsList, false);
                        TextView formalName = mealChunk.findViewById(R.id.formalName);
                        formalName.setText(item.getFormalName());
                        TextView meal = mealChunk.findViewById(R.id.meal);
                        meal.setText(item.getMeal());
                        Button moreInfo = mealChunk.findViewById(R.id.moreInfo);
                        mealsList.addView(mealChunk);

                    }
                }
            }
//            for (Item item : items) {
//                if(item.getTraits().contains("Vegetarian")) {
////                    System.out.println(item.getFormalName());
//                    View mealChunk = getLayoutInflater().inflate(R.layout.meal_chunk, mealsList, false);
//                    TextView formalName = mealChunk.findViewById(R.id.formalName);
//                    formalName.setText(item.getFormalName());
//                    TextView meal = mealChunk.findViewById(R.id.meal);
//                    meal.setText(item.getMeal());
//                    Button moreInfo = mealChunk.findViewById(R.id.moreInfo);
//                    mealsList.addView(mealChunk);
//
//                }
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}