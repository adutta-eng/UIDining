package com.example.uidining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;

import java.util.Calendar;
import java.util.TimeZone;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Calendar rightNow = Calendar.getInstance(TimeZone.getTimeZone("CST"));

        Button ike = findViewById(R.id.ikenberryHall3);
        Button par = findViewById(R.id.par3);
        Button busey = findViewById(R.id.buseyEvans3);
        Button lar = findViewById(R.id.lar3);
        Button far = findViewById(R.id.far3);
        Button blue = findViewById(R.id.blue3);
        Button orange = findViewById(R.id.orangeOnGreen3);
        Button north = findViewById(R.id.north3);
        Button cafe = findViewById(R.id.caffeinator3);
        Button ignite = findViewById(R.id.ignite3);

        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();

            double ikeDistance = getMiles(latitude, longitude, 40.103946, -88.235378);
            ike.setText("Ikenberry Dining Hall - " + ikeDistance + " mi");

            double parDistance = getMiles(latitude, longitude, 40.100733, -88.221019);
            par.setText("PAR Dining Hall - " + parDistance + " mi");

            double buseyDistance = getMiles(latitude, longitude, 40.105868, -88.222925);
            busey.setText("Busey Evans Dining Hall - " + buseyDistance + " mi");

            double larDistance = getMiles(latitude, longitude, 40.104435, -88.219141);
            lar.setText("LAR Dining Hall - " + larDistance + " mi");

            double farDistance = getMiles(latitude, longitude, 40.099529, -88.220972);
            far.setText("FAR Dining Hall - " + farDistance + " mi");

            double blueDistance = getMiles(latitude, longitude, 40.109686, -88.227072);
            blue.setText("Blue 41 - " + blueDistance + " mi");

            double orangeDistance = getMiles(latitude, longitude, 40.109686, -88.227072);
            orange.setText("Orange On Green - " + orangeDistance + " mi");

            double northDistance = getMiles(latitude, longitude, 40.103890, -88.235375);
            north.setText("57 North - " + northDistance + " mi");

            double caffeDistance = getMiles(latitude, longitude, 40.103890, -88.235375);
            cafe.setText("Caffeinator - " + caffeDistance + " mi");

            double igniteDistance = getMiles(latitude, longitude, 40.101567, -88.236115);
            ignite.setText("Ignite - " + igniteDistance + " mi");
        }

        ike.setOnClickListener(unused -> {
            Intent intent = new Intent(this, HallInformationActivity.class);
            intent.putExtra("HallID", Constants.IKE);
            intent.putExtra("Date",rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-" + rightNow.get(Calendar.DAY_OF_MONTH));
            startActivity(intent);
        });

        par.setOnClickListener(unused -> {
            Intent intent = new Intent(this, HallInformationActivity.class);
            startActivity(intent);
        });

        busey.setOnClickListener(unused -> {
            Intent intent = new Intent(this, HallInformationActivity.class);
            startActivity(intent);
        });

        lar.setOnClickListener(unused -> {
            Intent intent = new Intent(this, HallInformationActivity.class);
            startActivity(intent);
        });

        far.setOnClickListener(unused -> {
            Intent intent = new Intent(this, HallInformationActivity.class);
            startActivity(intent);
        });

        blue.setOnClickListener(unused -> {
            Intent intent = new Intent(this, HallInformationActivity.class);
            startActivity(intent);
        });

        orange.setOnClickListener(unused -> {
            Intent intent = new Intent(this, HallInformationActivity.class);
            startActivity(intent);
        });

        north.setOnClickListener(unused -> {
            Intent intent = new Intent(this, HallInformationActivity.class);
            startActivity(intent);
        });

        cafe.setOnClickListener(unused -> {
            Intent intent = new Intent(this, HallInformationActivity.class);
            startActivity(intent);
        });

        ignite.setOnClickListener(unused -> {
            Intent intent = new Intent(this, HallInformationActivity.class);
            startActivity(intent);
        });

        Button back = findViewById(R.id.informationBack);
        back.setOnClickListener(unused -> {
            startActivity(new Intent(this, MainActivity.class));
        });

    }

    private double getMiles(double firstLat, double firstLng, double secLat, double secLong) {
        final double latDistanceScale = 110574;
        final double lngDistanceScale = 111320;
        final double degToRad = Math.PI / 180;
        double latRadians = degToRad * firstLat;
        double latDistance = latDistanceScale * (firstLat - secLat);
        double lngDistance = lngDistanceScale * (firstLng - secLong) * Math.cos(latRadians);
        double meters = Math.sqrt(latDistance * latDistance + lngDistance * lngDistance);
        return (double) Math.round(100 * (meters / 1609.344)) / 100;
    }
}