package com.example.imageviewdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener {

	private Spinner spinnerCountries;
	private AutoCompleteTextView nameSelector;
	private ArrayAdapter<String> countryAdapter;
	private ArrayAdapter<String> namesAdapter;
	private ImageView imgCountryFlag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		countryAdapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_spinner_item);
		countryAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		countryAdapter.add("India");
		countryAdapter.add("England");
		countryAdapter.add("USA");

		spinnerCountries = (Spinner) findViewById(R.id.countries);
		spinnerCountries.setAdapter(countryAdapter);
		spinnerCountries.setOnItemSelectedListener(this);

		namesAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line);
		namesAdapter.add("Hiren");
		namesAdapter.add("Hitesh");
		namesAdapter.add("Darshan");
		namesAdapter.add("Daman");
		nameSelector = (AutoCompleteTextView) findViewById(R.id.nameSelector);
		nameSelector.setAdapter(namesAdapter);
		nameSelector.setTextColor(Color.RED);
		nameSelector.setThreshold(1);
		
		//imgCountryFlag=(ImageView)findViewById(R.id.)
	}

	@Override
	public void onItemSelected(AdapterView<?> adapterView, View view,
			int position, long id) {
		Toast.makeText(MainActivity.this,
				"You have selected " + countryAdapter.getItem(position),
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> adapterView) {
		// TODO Auto-generated method stub

	}

}
