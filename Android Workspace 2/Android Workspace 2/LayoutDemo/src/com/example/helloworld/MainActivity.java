package com.example.helloworld;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView lblName;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setTitle(getString(R.string.my_title));
		Log.i("vipul", "onCreate Called!!");
		setContentView(R.layout.activity_main);

		lblName = (TextView) findViewById(R.id.lblName);
		lblName.setText("Dynamic Name!!!");
		lblName.setTextColor(Color.RED);
		lblName.setTextSize(20);
		lblName.setTextAppearance(MainActivity.this,
				android.R.style.TextAppearance_Large);
	}

	@Override
	protected void onStart() {
		Log.i("vipul", "onStart Called!!");
		super.onStart();
	}

	@Override
	protected void onResume() {
		Log.i("vipul", "onResume Called!!");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.i("vipul", "onPause Called!!");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.i("vipul", "onStop Called!!");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.i("vipul", "onDestroy Called!!");
		super.onDestroy();
	}
}
