package com.example.foundsite;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener, GoogleMap.OnMapLongClickListener,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Button gasolina;
    private Button farmacia;
    private Button restaurant;
    private Button ubica;
    private TextView foundsites;

    // ubicaciones de gasolineras y su marker
    private static final LatLng g1 = new LatLng(-4.0133221, -79.2008686);
    private static final LatLng g2 = new LatLng(-4.0317731, -79.1986799);
    private static final LatLng g3 = new LatLng(-4.0018168, -79.2078316);
    private static final LatLng g4 = new LatLng(-3.9955772,-79.2049348);
    private static final LatLng g5 = new LatLng(-3.994646,-79.2103636);
    private static final LatLng g6 = new LatLng(-3.9834937,-79.1978216);
    private static final LatLng g7 = new LatLng(-27.47093, 153.0235);

    // ubicaciones de restaurantes y su marker
    private static final LatLng r1 = new LatLng(-4.0016911, -79.2089286);
    private static final LatLng r2 = new LatLng(-4.0055454, -79.2086269);
    private static final LatLng r3 = new LatLng(-4.006976 , -79.2072785);
    private static final LatLng r4 = new LatLng(-4.0082598,-79.2048101);
    private static final LatLng r5 = new LatLng(-4.0060337,-79.1999486);
    private static final LatLng r6 = new LatLng(-4.0078906,-79.2112769);
    private static final LatLng r7 = new LatLng(-4.0070264, -79.2142126);

    // coodenadas de farmacias

    private static final LatLng f1 = new LatLng(-4.026438, -79.203355);
    private static final LatLng f2 = new LatLng(-4.0249825, -79.2061472);
    private static final LatLng f3 = new LatLng(-4.0117221, -79.2023706);
    private static final LatLng f4 = new LatLng(-4.0103575,-79.2048061);
    private static final LatLng f5 = new LatLng(-4.0040323,-79.2015392);
    private static final LatLng f6 = new LatLng(-4.0039306,-79.2045486);
    private static final LatLng f7 = new LatLng(-3.9917456, -79.2040551);
    // marcadores de gasolinera
    private Marker gas1;
    private Marker gas2;
    private Marker gas3;
    private Marker gas4;
    private Marker gas5;
    private Marker gas6;
    private Marker gas7;
    // marcadores de restaurante
    private Marker res1;
    private Marker res2;
    private Marker res3;
    private Marker res4;
    private Marker res5;
    private Marker res6;
    private Marker res7;
    // marcadores de farmacias
    private Marker far1;
    private Marker far2;
    private Marker far3;
    private Marker far4;
    private Marker far5;
    private Marker far6;
    private Marker far7;


    LocationManager objLocation=null;
    LocationListener objLocListener =new Miposicion();;
    SharedPreferences prefs;
    MarcarPosicion objposicion = new MarcarPosicion();

//    final Marker marker = new Marker(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        foundsites=findViewById(R.id.FoundSites);
        farmacia=findViewById(R.id.Farmacia);
        gasolina=findViewById(R.id.Gasolina);
        restaurant=findViewById(R.id.Restaurat);
        farmacia.setOnClickListener(this);
        restaurant.setOnClickListener(this);
        gasolina.setOnClickListener(this);
        ubica=findViewById(R.id.Ubica);
        ubica.setOnClickListener(this);
        enableMyLocation();
//        miPosicion();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

    }


    public void marcadorgasolina(GoogleMap googleMap) {

//        Add some markers to the map, and add a data object to each marker.
        gas1 = mMap.addMarker(new MarkerOptions()
                .position(g1)
                .title("Gasolinera Valdiviezo")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                );
        gas1.setTag(0);

        gas2 = mMap.addMarker(new MarkerOptions()
                .position(g2)
                .title("Gasolinera Argelia")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
        );
        gas2.setTag(0);

        gas3 = mMap.addMarker(new MarkerOptions()
                .position(g3)
                .title("Gasolinera Foodtruck")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
        );
        gas3.setTag(0);

        gas4 = mMap.addMarker(new MarkerOptions()
                .position(g4)
                .title("Gasolinera Jaramillo")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        gas4.setTag(0);

        gas5 = mMap.addMarker(new MarkerOptions()
                .position(g5)
                .title("Gasolinera la Llave")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        gas5.setTag(0);

        gas6 = mMap.addMarker(new MarkerOptions()
                .position(g6)
                .title("San Cayetano")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        gas6.setTag(0);

        gas7 = mMap.addMarker(new MarkerOptions()
                .position(g7)
                .title("Brisbane")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        gas7.setTag(0);


        // Centrar Marcadores
        LatLngBounds.Builder constructor = new LatLngBounds.Builder();

        constructor.include(g1);
        constructor.include(g2);
        constructor.include(g3);
        constructor.include(g4);

        LatLngBounds limites = constructor.build();

        int ancho = getResources().getDisplayMetrics().widthPixels;
        int alto = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (alto * 0.25); // 25% de espacio (padding) superior e inferior

        CameraUpdate centrarmarcadores = CameraUpdateFactory.newLatLngBounds(limites, ancho, alto, padding);
        CameraUpdate ZoomCam=CameraUpdateFactory.zoomTo(26);
        mMap.animateCamera(ZoomCam);

        mMap.animateCamera(centrarmarcadores);
    }

    public void marcadorRestaurante(GoogleMap googleMap) {

        ////         Add some markers to the map, and add a data object to each marker.
        res1 = mMap.addMarker(new MarkerOptions()
                .position(r1)
                .title("La Nona Restaurant")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        res1.setTag(0);

        res2 = mMap.addMarker(new MarkerOptions()
                .position(r2)
                .title("Huaquillitas")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        res2.setTag(0);

        res3 = mMap.addMarker(new MarkerOptions()
                .position(r3)
                .title("El Patio Burguer Grill")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        res3.setTag(0);

        res4 = mMap.addMarker(new MarkerOptions()
                .position(r4)
                .title("A Papiar Restaurant Wor")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        res4.setTag(0);

        res5 = mMap.addMarker(new MarkerOptions()
                .position(r5)
                .title("Ricuras de sal y dulce")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        res5.setTag(0);

        res6 = mMap.addMarker(new MarkerOptions()
                .position(r6)
                .title("Restaurante LA CAMPIÑA")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        res6.setTag(0);

        res7 = mMap.addMarker(new MarkerOptions()
                .position(r7)
                .title("Cali Pizza - Fresh & Hot")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        res7.setTag(0);


        // Centrar Marcadores
        LatLngBounds.Builder constructor = new LatLngBounds.Builder();

        constructor.include(r1);
        constructor.include(r2);
        constructor.include(r3);
        constructor.include(r4);
        constructor.include(r5);
        constructor.include(r6);
        constructor.include(r7);

        LatLngBounds limites = constructor.build();

        int ancho = getResources().getDisplayMetrics().widthPixels;
        int alto = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (alto * 0.25); // 25% de espacio (padding) superior e inferior

        CameraUpdate centrarmarcadores = CameraUpdateFactory.newLatLngBounds(limites, ancho, alto, padding);
        CameraUpdate ZoomCam=CameraUpdateFactory.zoomTo(26);
        mMap.animateCamera(ZoomCam);

        mMap.animateCamera(centrarmarcadores);
    }

    public void marcadorfarmacia(GoogleMap googleMap) {

        ////         Add some markers to the map, and add a data object to each marker.
        far1 = mMap.addMarker(new MarkerOptions()
                .position(f1)
                .title("Farmacia San Isidro"));
        far1.setTag(0);

        far2 = mMap.addMarker(new MarkerOptions()
                .position(f2)
                .title("Farmacia Fernandito"));
        far2.setTag(0);

        far3 = mMap.addMarker(new MarkerOptions()
                .position(f3)
                .title("Fybeca"));
        far3.setTag(0);

        far4 = mMap.addMarker(new MarkerOptions()
                .position(f4)
                .title("Sana Sana"));
        far4.setTag(0);

        far5 = mMap.addMarker(new MarkerOptions()
                .position(f5)
                .title("Pharmacy's"));
        far5.setTag(0);

        far6 = mMap.addMarker(new MarkerOptions()
                .position(f6)
                .title("Farmacias San Eduardo"));
        far6.setTag(0);

        far7 = mMap.addMarker(new MarkerOptions()
                .position(f7)
                .title("Farmacias Mia"));
        far7.setTag(0);


        // Centrar Marcadores
        LatLngBounds.Builder constructor = new LatLngBounds.Builder();

        constructor.include(f1);
        constructor.include(f2);
        constructor.include(f3);
        constructor.include(f4);
        constructor.include(f5);
        constructor.include(f6);
        constructor.include(f7);

        LatLngBounds limites = constructor.build();

        int ancho = getResources().getDisplayMetrics().widthPixels;
        int alto = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (alto * 0.25); // 25% de espacio (padding) superior e inferior

        CameraUpdate centrarmarcadores = CameraUpdateFactory.newLatLngBounds(limites, ancho, alto, padding);
        CameraUpdate ZoomCam=CameraUpdateFactory.zoomTo(26);
        mMap.animateCamera(ZoomCam);

        mMap.animateCamera(centrarmarcadores);

    }

    private void miPosicion(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1000);

        }

        objLocation=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        objLocation.requestLocationUpdates(LocationManager.GPS_PROVIDER,100000,0,objLocListener);

        if(objLocation.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Toast.makeText(this,"GPS habilitado",Toast.LENGTH_SHORT).show();

            LatLng loja= new LatLng(Miposicion.latitud,Miposicion.longitud);
            mMap.addMarker(new MarkerOptions().position(loja).title("Marker in Loja"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(loja));
            CameraUpdate ZoomCam=CameraUpdateFactory.zoomTo(22);
            mMap.animateCamera(ZoomCam);

        }else{
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("GPS NO ESTA ACTIVO");
            alert.setPositiveButton("OK",null);
            alert.create().show();
        }

    }

    private void enableMyLocation(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1000 );
        }
    }


    @Override
    public void onClick(View view) {
        if(view== ubica){
            miPosicion();
        }
        if(view==restaurant){
            marcadorRestaurante(mMap);
        }
        if(view==gasolina){
              marcadorgasolina(mMap);

        }
        if(view==farmacia){
            marcadorfarmacia(mMap);

        }

    }

    @Override
    public void onMapLongClick(LatLng punto) {
        Toast.makeText(MapsActivity.this,"Click posiscion"+punto.latitude+punto.longitude,Toast.LENGTH_SHORT).show();
        prefs=getSharedPreferences("MyPreferencia", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=prefs.edit();

        ed.putFloat("latitud",(float)punto.latitude);
        ed.putFloat("longitud",(float)punto.longitude);
        ed.commit();

        mMap.addMarker(new MarkerOptions().position(new LatLng(punto.latitude,punto.longitude)));

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        // Retrieve the data from the marker.
        Integer clickCount = (Integer) marker.getTag();

        // Check if a click count was set, then display the click count.
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();
        }

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    //en este metodo lo q hacemos es convertit las coorenadas en direcciones
    private abstract class milocalizacionListener implements LocationListener{
        @Override
        public void onLocationChanged(Location location) {
            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            try {
                List<Address> direccion1 = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(), 1);
                foundsites.setText(direccion1.get(0).getAddressLine(0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
