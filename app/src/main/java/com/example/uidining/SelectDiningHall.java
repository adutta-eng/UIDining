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
        Calendar rightNow = Calendar.getInstance(TimeZone.getTimeZone("CST"));
        String formattedDate = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + rightNow.get(Calendar.DAY_OF_MONTH);

        Button ikenberryHall = findViewById(R.id.ikenberryHall);
        ikenberryHall.setOnClickListener(unused -> {
//            System.out.println(rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + rightNow.get(Calendar.DAY_OF_MONTH));
            Intent intent = new Intent(this, VegetarianMeals.class);
            intent.putExtra("HallID", Constants.IKE);
//            intent.putExtra("Date", formattedDate);
            intent.putExtra("Date","2019-12-2");
            startActivity(intent);
        });

        Button par = findViewById(R.id.par);
        par.setOnClickListener(unused -> {
//            System.out.println(rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + rightNow.get(Calendar.DAY_OF_MONTH));
            Intent intent = new Intent(this, VegetarianMeals.class);
            intent.putExtra("HallID", Constants.PAR);
            intent.putExtra("Date", formattedDate);
//            intent.putExtra("Date","2019-12-2");
            startActivity(intent);
        });

        Button backtoPrefs = findViewById(R.id.backToPrefs);
        backtoPrefs.setOnClickListener(unused -> {
            startActivity(new Intent(this, InputPreferences.class));
        });
    }
}
