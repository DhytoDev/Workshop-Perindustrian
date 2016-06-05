package com.dhytodev.datakemiskinan;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.dhytodev.datakemiskinan.util.GpsTracker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private Toolbar mToolbar;
    @Bind(R.id.button_terrain)
    Button btnTerrain ;
    @Bind(R.id.button_hybrid) Button btnHybrid ;
    @Bind(R.id.button_normal) Button btnNormal ;
    @Bind(R.id.button_satelite) Button btnSatelite ;

    private GpsTracker gps ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maps);
        ButterKnife.bind(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);

        btnTerrain.setOnClickListener(this);
        btnHybrid.setOnClickListener(this);
        btnNormal.setOnClickListener(this);
        btnSatelite.setOnClickListener(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng bangkala = new LatLng(-5.4968687, 119.5557463);
        LatLng arungkeke = new LatLng(-5.6664737,119.8017753);
        LatLng tamalatea = new LatLng(-5.6846517,119.6640373);
        mMap.addMarker(new MarkerOptions().position(bangkala).title("Marker in Bangkala"));
        mMap.addMarker(new MarkerOptions().position(arungkeke).title("Marker in Arungkeke"));
        mMap.addMarker(new MarkerOptions().position(tamalatea).title("Marker in Tamalatea"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bangkala, 17));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);

        //gps = new GpsTracker(MapsActivity.this);

        /*if(gps.canGetLocation()) {
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude() ;

            LatLng posisi = new LatLng(latitude, longitude);

            mMap.addMarker(new MarkerOptions().position(posisi).title("posisi anda"))
                    .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));


        } */
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.button_satelite:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break ;
            case R.id.button_hybrid:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break ;
            case R.id.button_normal:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.button_terrain:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
        }
    }
}
