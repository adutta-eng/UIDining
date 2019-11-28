package com.example.uidining;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VegetarianMeals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetarian_meals);
        LinearLayout mealsList = findViewById(R.id.mealsList);
        View mealChunk = getLayoutInflater().inflate(R.layout.meal_chunk, mealsList, false);
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            textView.setText("this worked" + response.get("Menus"));
//                        } catch(JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                textView.setText("That didn't work!");
//            }
//        });
//        queue.add(jsonObjectRequest);
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
    }

    private void setUpUi(final JSONObject result) {
        LinearLayout mealsList = findViewById(R.id.mealsList);
        try {
            JSONArray mealsArray = result.getJSONArray("Item");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
