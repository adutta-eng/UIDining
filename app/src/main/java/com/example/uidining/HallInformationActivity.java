package com.example.uidining;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HallInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hall_information);

        TextView breakfast = findViewById(R.id.breakfast);
        TextView lightLunch = findViewById(R.id.lightLunch);
        TextView lunch = findViewById(R.id.lunch);
        TextView dinner = findViewById(R.id.dinner);
        TextView lateDinner = findViewById(R.id.lateDinner);
        TextView dailyMenu = findViewById(R.id.dailyMenu);

        Button back = findViewById(R.id.backToInfo);
        back.setOnClickListener(unused -> {
            breakfast.setVisibility(View.GONE);
            lightLunch.setVisibility(View.GONE);
            lunch.setVisibility(View.GONE);
            dinner.setVisibility(View.GONE);
            lateDinner.setVisibility(View.GONE);
            dailyMenu.setVisibility(View.GONE);
            startActivity(new Intent(this, InformationActivity.class));
        });


        Intent intent = getIntent();
        int hall = intent.getIntExtra("HallID", 1);

        if (hall == Constants.IKE) {
            TextView hallName = findViewById(R.id.hallName);
            hallName.setText("Ikenberry Dining Hall");

            Button maps = findViewById(R.id.maps);
            Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=40.103946, -88.235378"));
            maps.setOnClickListener(unused -> {
                startActivity(mapIntent);
            });

            breakfast.setVisibility(View.VISIBLE);
            lightLunch.setVisibility(View.VISIBLE);
            lunch.setVisibility(View.VISIBLE);
            dinner.setVisibility(View.VISIBLE);

            breakfast.setText("Breakfast : 7:00 AM - 10:00 AM");
            lunch.setText("Lunch : 10:30 AM - 1:30 PM");
            lightLunch.setText("Light Lunch : 1:30 PM - 3:00 PM");
            dinner.setText("Dinner : 4:30 PM - 8:00 PM");
        }

        if (hall == Constants.PAR) {
            TextView hallName = findViewById(R.id.hallName);
            hallName.setText("PAR Dining Hall");

            Button maps = findViewById(R.id.maps);
            Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=40.100733, -88.221019"));
            maps.setOnClickListener(unused -> {
                startActivity(mapIntent);
            });

            breakfast.setVisibility(View.VISIBLE);
            lightLunch.setVisibility(View.VISIBLE);
            lunch.setVisibility(View.VISIBLE);
            dinner.setVisibility(View.VISIBLE);
            lateDinner.setVisibility(View.VISIBLE);

            breakfast.setText("Breakfast : 7:00 AM - 9:30 AM");
            lunch.setText("Lunch : 11:00 AM - 1:30 PM");
            lightLunch.setText("Light Lunch : 1:30 PM - 3:00 PM");
            dinner.setText("Dinner : 4:30 PM - 7:00 PM");
            lateDinner.setText("Late Dinner : 8:00 PM - 12:00 AM");
        }

        if (hall == Constants.BUSEY_EVANS) {
            TextView hallName = findViewById(R.id.hallName);
            hallName.setText("Busey Evans Dining Hall");

            Button maps = findViewById(R.id.maps);
            Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=40.105868, -88.222925"));
            maps.setOnClickListener(unused -> {
                startActivity(mapIntent);
            });

            lunch.setVisibility(View.VISIBLE);
            dinner.setVisibility(View.VISIBLE);

            lunch.setText("Lunch : 11:00 AM - 1:30 PM");
            dinner.setText("Dinner : 4:45 PM - 6:30 PM");
        }

        if (hall == Constants.LAR) {
            TextView hallName = findViewById(R.id.hallName);
            hallName.setText("LAR Dining Hall");

            Button maps = findViewById(R.id.maps);
            Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=40.104435, -88.219141"));
            maps.setOnClickListener(unused -> {
                startActivity(mapIntent);
            });

            breakfast.setVisibility(View.VISIBLE);
            lunch.setVisibility(View.VISIBLE);
            dinner.setVisibility(View.VISIBLE);

            breakfast.setText("Breakfast : 7:00 AM - 9:30 AM");
            lunch.setText("Lunch : 11:00 AM - 1:30 PM");
            dinner.setText("Dinner : 4:45 PM - 6:30 PM");
        }

        if (hall == Constants.FAR) {
            TextView hallName = findViewById(R.id.hallName);
            hallName.setText("FAR Dining Hall");

            Button maps = findViewById(R.id.maps);
            Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=40.099529, -88.220972"));
            maps.setOnClickListener(unused -> {
                startActivity(mapIntent);
            });

            lunch.setVisibility(View.VISIBLE);
            dinner.setVisibility(View.VISIBLE);

            lunch.setText("Lunch : 11:00 AM - 1:30 PM");
            dinner.setText("Dinner : 4:45 PM - 7:30 PM");
        }

        if (hall == Constants.BLUE) {
            TextView hallName = findViewById(R.id.hallName);
            hallName.setText("Blue 41");

            Button maps = findViewById(R.id.maps);
            Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=40.109686, -88.227072"));
            maps.setOnClickListener(unused -> {
                startActivity(mapIntent);
            });

            breakfast.setVisibility(View.VISIBLE);
            lunch.setVisibility(View.VISIBLE);
            dinner.setVisibility(View.VISIBLE);

            breakfast.setText("Breakfast : 7:00 AM - 10:30 AM");
            lunch.setText("Lunch : 10:30 AM - 1:30 PM");
            dinner.setText("Dinner : 4:30 PM - 8:00 PM");
        }

        if (hall == Constants.ORANGE_ON_GREEN) {
            TextView hallName = findViewById(R.id.hallName);
            hallName.setText("Orange On Green");

            Button maps = findViewById(R.id.maps);
            Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=40.109686, -88.227072"));
            maps.setOnClickListener(unused -> {
                startActivity(mapIntent);
            });

            lunch.setVisibility(View.VISIBLE);

            lunch.setText("Lunch : 10:30 AM - 4:30 PM");
        }

        if (hall == Constants.NORTH) {
            TextView hallName = findViewById(R.id.hallName);
            hallName.setText("57 North");

            Button maps = findViewById(R.id.maps);
            Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=40.103890, -88.235375"));
            maps.setOnClickListener(unused -> {
                startActivity(mapIntent);
            });

            dailyMenu.setVisibility(View.VISIBLE);

            dailyMenu.setText("Daily Menu: 9:00 AM - 12:00 AM");
        }

        if (hall == Constants.CAFFEINATOR) {
            TextView hallName = findViewById(R.id.hallName);
            hallName.setText("Caffeinator");

            Button maps = findViewById(R.id.maps);
            Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=40.103890, -88.235375"));
            maps.setOnClickListener(unused -> {
                startActivity(mapIntent);
            });

            dailyMenu.setVisibility(View.VISIBLE);

            dailyMenu.setText("Daily Menu: 7:00 AM - 12:00 AM");
        }

        if (hall == Constants.IGNITE) {
            TextView hallName = findViewById(R.id.hallName);
            hallName.setText("Ignite");

            Button maps = findViewById(R.id.maps);
            Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=40.101567, -88.236115"));
            maps.setOnClickListener(unused -> {
                startActivity(mapIntent);
            });

            dailyMenu.setVisibility(View.VISIBLE);

            dailyMenu.setText("Daily Menu: 10:00 AM - 10:00 PM");
        }

        connect(intent.getIntExtra("HallID", 1), intent.getStringExtra("Date"));
    }

    //retrieve JSON object from API and set up UI accordingly
    private void connect(int diningId, String date){
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setUpUi(final JSONObject result) {
        LinearLayout mealsList = findViewById(R.id.foodList);
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
            for (Item item : items) {
                View mealChunk = getLayoutInflater().inflate(R.layout.meal_chunk, mealsList, false);
                TextView formalName = mealChunk.findViewById(R.id.formalName);
                formalName.setText(item.getFormalName());
                TextView meal = mealChunk.findViewById(R.id.meal);
                meal.setText(item.getMeal());
                Button moreInfo = mealChunk.findViewById(R.id.moreInfo);
                mealsList.addView(mealChunk);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}