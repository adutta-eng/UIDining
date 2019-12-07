package com.example.uidining;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

//        final TextView textView = findViewById(R.id.text);
        Button pref = findViewById(R.id.inputPreference);
        pref.setOnClickListener(unused -> {
            startActivity(new Intent(this, InputPreferences.class));
        });
        Button information = findViewById(R.id.information);
        information.setOnClickListener(unused -> {
            startActivity(new Intent(this, InformationActivity.class));
        });
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url ="http://uiuc-api2.herokuapp.com/dining/2/2019-12-02/2019-12-02";
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
}
