package assignment.com.earthquakemonitor.UI.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import assignment.com.earthquakemonitor.AppController;
import assignment.com.earthquakemonitor.Model.FeatureModel;
import assignment.com.earthquakemonitor.Model.GeometryModel;
import assignment.com.earthquakemonitor.Model.PropertiesModel;
import assignment.com.earthquakemonitor.R;

public class DetailsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMarkerClickListener {

    private FeatureModel featureModel;
    private GeometryModel geometryModel;
    private PropertiesModel propertiesModel;

    private TextView tvMag;
    private TextView tvDate;
    private TextView tvLocation;

    SupportMapFragment mapFragment;
    Map<String, Integer> mMarkers = new HashMap<String, Integer>();
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        featureModel = this.getIntent().getParcelableExtra(AppController.INTENT_KEY_FEATURE_DATA);
        geometryModel = this.getIntent().getParcelableExtra(AppController.INTENT_KEY_FEATURE_DATA_GEOMETRY);
        propertiesModel = this.getIntent().getParcelableExtra(AppController.INTENT_KEY_FEATURE_DATA_PROPERTIES);
        validate();
        getSupportActionBar().setTitle(propertiesModel.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvMag= findViewById(R.id.tvMag);
        tvDate= findViewById(R.id.tvDate);
        tvLocation= findViewById(R.id.tvLocation);

        tvMag.setText(AppController.getString(propertiesModel.getMag() + ""));
        tvDate.setText(AppController.getTime(propertiesModel.getTime()));
        tvLocation.setText(AppController.getString(propertiesModel.getPlace() + "\n" + "LatLng: " + AppController.getString(geometryModel.getCoordinates().get(0)) + "," + AppController.getString(geometryModel.getCoordinates().get(1)) + "\nDepth: " + AppController.getString(geometryModel.getCoordinates().get(2))));


        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    private void initListeners() {

        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMapClickListener(this);
    }

    private void removeListeners() {
        if (googleMap != null) {
            googleMap.setOnMarkerClickListener(null);
            googleMap.setOnMapClickListener(null);
        }
    }

    private void validate() {
        if (featureModel == null) {
            Toast.makeText(this, "Invalid Data", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.googleMap = googleMap;

        LatLng latLng;

        try {
            latLng = new LatLng(Double.parseDouble(geometryModel.getCoordinates().get(0)), Double.parseDouble(geometryModel.getCoordinates().get(1)));
            CameraPosition position = CameraPosition.builder()
                    .target(latLng)
                    .zoom(15f)
                    .bearing(0.0f)
                    .tilt(0.0f)
                    .build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(position), null);

            initListeners();

            loadMarker(latLng);
        } catch (Exception ex) {
            Toast.makeText(this, "Unable to load map", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    private void loadMarker(LatLng latLng) {
        //LatLng latLng = new LatLng(Double.valueOf(item1.getLat()), Double.valueOf(item1.getLng()));

        final MarkerOptions options = new MarkerOptions().position(latLng);

        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

        googleMap.addMarker(options);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeListeners();
    }
}
