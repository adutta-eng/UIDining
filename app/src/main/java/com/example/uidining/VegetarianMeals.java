package com.example.uidining;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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
import java.util.List;

public class VegetarianMeals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetarian_meals);
        connect();
    }

    //retrieve JSON object from API and set up UI accordingly
    private void connect(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://uiuc-api2.herokuapp.com/dining/2/2019-12-02/2019-12-02";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            setUpUi(response.getJSONObject("Menus"));
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

    private void setUpUi(final JSONObject result) {
        LinearLayout mealsList = findViewById(R.id.mealsList);
        mealsList.removeAllViews();
        try {
            JSONArray mealItemsArray = result.getJSONArray("Item");
            Gson gson = new Gson();
            List<Item> items = Arrays.asList(gson.fromJson(mealItemsArray.toString(),Item[].class));
            for (Item item : items) {
                if(item.getTraits().contains("Vegetarian")) {
                    View mealChunk = getLayoutInflater().inflate(R.layout.meal_chunk, mealsList, false);
                    System.out.println(item.getFormalName());
                    TextView formalName = mealChunk.findViewById(R.id.formalName);
                    formalName.setText(item.getFormalName());
                    TextView meal = mealChunk.findViewById(R.id.meal);
                    meal.setText(item.getMeal());
                    Button moreInfo = mealChunk.findViewById(R.id.moreInfo);
                    mealsList.addView(mealChunk);

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
