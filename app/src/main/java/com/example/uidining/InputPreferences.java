package com.example.uidining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class InputPreferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_preferences);
        Button vegetarian = findViewById(R.id.vegetarian);
        vegetarian.setOnClickListener(unused -> {
            startActivity(new Intent(this, SelectDiningHall.class));
        });
        Button gf = findViewById(R.id.glutenFree);
        Button halal = findViewById(R.id.halal);
        Button home = findViewById(R.id.back);
        home.setOnClickListener(unused -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}
