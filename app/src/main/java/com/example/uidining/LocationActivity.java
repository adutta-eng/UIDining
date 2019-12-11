package com.example.uidining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        Button ike = findViewById(R.id.ikenberryHall2);
        ike.setOnClickListener(unused -> {
            startActivity(new Intent(this, HallInformationActivity.class));
        });

        Button back = findViewById(R.id.locationBack);
        back.setOnClickListener(unused -> {
            startActivity(new Intent(this, MainActivity.class));
        });

    }
}
