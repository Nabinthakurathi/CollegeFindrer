package com.nabin.collegerfinder;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nabin.collegerfinder.Bll.LongitudeLongitude;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        List<LongitudeLongitude> latLngs = new ArrayList<>();
        latLngs.add(new LongitudeLongitude(27.706195,85.3300396, "Marker in Softwarica College"));
        latLngs.add(new LongitudeLongitude(27.68984, 85.339821, "Marker in Uniglobe College"));
        latLngs.add(new LongitudeLongitude(27.6879188,85.3504956, "Marker in Nasa College"));
        latLngs.add(new LongitudeLongitude(27.7067942, 85.3254032, "Marker in NIC College"));
        latLngs.add(new LongitudeLongitude(27.7055835,85.3343087, "Marker in Sunway College"));
        latLngs.add(new LongitudeLongitude(27.7087027,85.3259876, "Marker in Islington College"));


        CameraUpdate center, zoom;
        for (int i= 0; i <latLngs.size(); i++) {
            center =
                    CameraUpdateFactory.newLatLng(new LatLng(latLngs.get(i).getLat(),
                            latLngs.get(i).getLon()));
            zoom =
                    CameraUpdateFactory.zoomTo(16);
            mMap.addMarker(new MarkerOptions().position(new LatLng(latLngs.get(i).getLat(),
                    latLngs.get(i).getLon())).title(latLngs.get(i).getMarker()));

            mMap.moveCamera(center);
            mMap.animateCamera(zoom);
            mMap.getUiSettings().setZoomControlsEnabled(true);
        }
    }
}