package com.example.listviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {

	private ListView cityList;
	private Button btnPopulate;
	private ArrayAdapter<String> cityAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String[] cities = getResources().getStringArray(R.array.cities);

		cityAdapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_list_item_1);

		for (String city : cities) {
			cityAdapter.add(city);
		}

		cityList = (ListView) findViewById(R.id.cityList);

		btnPopulate = (Button) findViewById(R.id.btnPopulate);
		btnPopulate.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		cityList.setAdapter(cityAdapter);
	}


}
