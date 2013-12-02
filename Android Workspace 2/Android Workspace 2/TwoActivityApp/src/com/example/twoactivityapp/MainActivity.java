package com.example.twoactivityapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnSwitchActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("First Activity");
		setContentView(R.layout.activity_main);

		btnSwitchActivity = (Button) findViewById(R.id.switchActivity);
		btnSwitchActivity.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		intent.putExtra("username", "Vipul");
		intent.putExtra("password", "vipul123");
		startActivity(intent);
	}
}
