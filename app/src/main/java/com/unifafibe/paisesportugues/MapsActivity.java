package com.unifafibe.paisesportugues;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String nome = null;
    Double coordenadasLat = 0.0;
    Double coordenadasLong = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Bundle b = getIntent().getExtras();

        if(b != null)
            nome = b.getString("nome");
        System.out.println(nome);

        if(b != null)
            coordenadasLat = b.getDouble("coordenadasLat");
        System.out.println(coordenadasLat);

        if(b != null)
            coordenadasLong = b.getDouble("coordenadasLong");
        System.out.println(coordenadasLong);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng cidade = new LatLng(coordenadasLat, coordenadasLong);
        mMap.addMarker(new MarkerOptions().position(cidade).title(nome));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cidade));
    }
}