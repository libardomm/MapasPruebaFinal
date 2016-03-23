package com.example.libardo.mapaspruebafinal;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends ActionBarActivity implements LocationListener {
     LocationManager locationManager;
     String provider;
     Location location=new Location("l1");
     Location location2=new Location("l2");
    String a;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);

        provider =locationManager.getBestProvider(new Criteria(),false);

        location =locationManager.getLastKnownLocation(provider);


        if(location!=null){
            Log.i("Location Info", "Si encontro ubicacion");

        } else{
            Log.i("Location Info", "No se encontro la ubiacion");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    //--------------------------------------------------------------------------------------------------
    @Override
    public void onLocationChanged(Location location) {
        Double lat= location.getLatitude();
        Double lng=location.getLongitude();

        Log.i("Longitud", lat.toString());
        Log.i("Latitud", lng.toString());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Double lat= location.getLatitude();
        Double lng=location.getLongitude();

        Log.i("Longitud", lat.toString());
        Log.i("Latitud", lng.toString());
    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public void getLocationMethod(View v){
        location= locationManager.getLastKnownLocation(provider);
        onLocationChanged(location);




    }
    public void getLocationMethodEnd(View v){
       location2= locationManager.getLastKnownLocation(provider);
        onLocationChanged(location2);


    }
    public void calculardistancia(View v) {

       // Log.i("La distancia es", a);
       Double longitud;
        longitud=location.getLongitude();
       Float distanciaEnMetros = location.distanceTo(location2);
        Log.i("La distancia es", distanciaEnMetros.toString());



    }




    public void getAltitud(View v){
       Location location=locationManager.getLastKnownLocation(provider);
        Double altitud=location.getAltitude();
        Log.i("Altitud:",altitud.toString());

    }
}
