package com.example.mapapplication;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class MainActivity extends Activity {

	private GoogleMap mapFragment;
	private LatLngBounds AUSTRALIA = new LatLngBounds(new LatLng(-44, 113),
			new LatLng(-10, 154));

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mapFragment = ((MapFragment) getFragmentManager().findFragmentById(
				R.id.map)).getMap();
		mapFragment.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		mapFragment.moveCamera(CameraUpdateFactory.newLatLngZoom(
				AUSTRALIA.getCenter(), 10));
	}

}
