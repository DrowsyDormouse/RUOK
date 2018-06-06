package com.example.ch555.myapplication;

import android.app.FragmentManager;
import android.app.RemoteAction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class reliefarea extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleApiClient mGoogleApiClient;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reliefarea);

        final Button a = (Button)findViewById(R.id.button);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(reliefarea.this, Adsearch.class);
                startActivity(i);
            }
        });
        final Switch sw = (Switch)findViewById(R.id.switch2);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(sw.isChecked()) {
                    a.setEnabled(true);
                }
                else {
                    a.setEnabled(false);
                }
            }

        });

    }

    private void setViewAndChildrenEnable(View view, boolean enabled) {
        view.setEnabled(enabled);
        if (view instanceof ViewGroup){
            ViewGroup viewGroup = (ViewGroup)view;
            for(int i=0;i<viewGroup.getChildCount();i++){
                View child = viewGroup.getChildAt(i);
                setViewAndChildrenEnable(child,enabled);
            }
        }
    }

    public void onMapReady(final GoogleMap map) {
        LatLng SEOUL = new LatLng(37.56, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        map.addMarker(markerOptions);

        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }

}