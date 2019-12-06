package com.example.uidining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.TimeZone;

public class SelectDiningHall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dining_hall);
        Intent currentIntent = getIntent();
        String dietaryPref = currentIntent.getStringExtra("Restriction");
        Calendar rightNow = Calendar.getInstance(TimeZone.getTimeZone("America/Chicago"));
        System.out.println(rightNow.toString());
        String formattedDate = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + rightNow.get(Calendar.DAY_OF_MONTH);
        System.out.println(formattedDate);
        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(unused -> {
            startActivity(new Intent(this, InputPreferences.class));
        });
//        String formattedDate = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + rightNow.get(Calendar.DAY_OF_MONTH);

        Button ikenberryHall = findViewById(R.id.ikenberryHall);
        ikenberryHall.setOnClickListener(unused -> {
            System.out.println(rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + rightNow.get(Calendar.DAY_OF_MONTH));
            Intent intent = new Intent(this, VegetarianMeals.class);
            intent.putExtra("HallID", Constants.IKE);
            intent.putExtra("Date", formattedDate);
//            intent.putExtra("Date","2019-12-5");
            intent.putExtra("Restriction", dietaryPref);
            startActivity(intent);
        });

        Button par = findViewById(R.id.par);
        par.setOnClickListener(unused -> {
            System.out.println(rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + rightNow.get(Calendar.DAY_OF_MONTH));
            Intent intent = new Intent(this, VegetarianMeals.class);
            intent.putExtra("HallID", Constants.PAR);
            intent.putExtra("Date", formattedDate);
//            intent.putExtra("Date","2019-12-2");
            intent.putExtra("Restriction", dietaryPref);
            startActivity(intent);
        });

        Button buseyEvans = findViewById(R.id.buseyEvans);
        buseyEvans.setOnClickListener(unused -> {
            System.out.println(rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + rightNow.get(Calendar.DAY_OF_MONTH));
            Intent intent = new Intent(this, VegetarianMeals.class);
            intent.putExtra("HallID", Constants.BUSEY_EVANS);
            intent.putExtra("Date", formattedDate);
//            intent.putExtra("Date","2019-12-2");
            intent.putExtra("Restriction", dietaryPref);
            startActivity(intent);
        });

        Button lar = findViewById(R.id.lar);
        lar.setOnClickListener(unused -> {
            System.out.println(rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + rightNow.get(Calendar.DAY_OF_MONTH));
            Intent intent = new Intent(this, VegetarianMeals.class);
            intent.putExtra("HallID", Constants.LAR);
            intent.putExtra("Date", formattedDate);
//            intent.putExtra("Date","2019-12-2");
            intent.putExtra("Restriction", dietaryPref);
            startActivity(intent);
        });

        Button far = findViewById(R.id.far);
        System.out.println(rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + rightNow.get(Calendar.DAY_OF_MONTH));
        far.setOnClickListener(unused -> {
            Intent intent = new Intent(this, VegetarianMeals.class);
            intent.putExtra("HallID", Constants.FAR);
            intent.putExtra("Date", formattedDate);
//            intent.putExtra("Date","2019-12-2");
            intent.putExtra("Restriction", dietaryPref);
            startActivity(intent);
        });

        Button blue = findViewById(R.id.blue);
        blue.setOnClickListener(unused -> {
            Intent intent = new Intent(this, VegetarianMeals.class);
            intent.putExtra("HallID", Constants.BLUE);
            intent.putExtra("Date", formattedDate);
//            intent.putExtra("Date","2019-12-2");
            intent.putExtra("Restriction", dietaryPref);
            startActivity(intent);
        });

        Button orange = findViewById(R.id.orangeOnGreen);
        orange.setOnClickListener(unused -> {
            Intent intent = new Intent(this, VegetarianMeals.class);
            intent.putExtra("HallID", Constants.ORANGE_ON_GREEN);
            intent.putExtra("Date", formattedDate);
//            intent.putExtra("Date","2019-12-2");
            intent.putExtra("Restriction", dietaryPref);
            startActivity(intent);
        });
    }
}