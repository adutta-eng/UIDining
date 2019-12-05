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
            Intent intent = new Intent(this, SelectDiningHall.class);
            intent.putExtra("Restriction", "Vegetarian");
            startActivity(intent);
        });
        Button gf = findViewById(R.id.glutenFree);
        gf.setOnClickListener(unused -> {
            Intent intent = new Intent(this, SelectDiningHall.class);
            intent.putExtra("Restriction", "Gluten");
            startActivity(intent);
        });
        Button halal = findViewById(R.id.halal);
        halal.setOnClickListener(unused -> {
            Intent intent = new Intent(this, SelectDiningHall.class);
            intent.putExtra("Restriction", "Halal");
            startActivity(intent);
        });
        Button home = findViewById(R.id.back);
        home.setOnClickListener(unused -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}
