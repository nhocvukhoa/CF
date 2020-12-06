package com.example.coffehouse.CuaHang;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.coffehouse.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


public class CuaHangFragment extends Fragment implements OnMapReadyCallback {

    private static CuaHangFragment INSTANCE=null;
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;
    View view;
    GoogleMap map;
    MapView mapView;

    public CuaHangFragment(){
    }
    public static CuaHangFragment getINSTANCE(){
        if (INSTANCE==null)
            INSTANCE=new CuaHangFragment();
        return INSTANCE;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cuahang, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@Nullable View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        mapView=view.findViewById(R.id.mapsView);
        if(mapView!=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        map=googleMap;
    }
}