package com.example.servicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnStartTimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnStartTimer = (Button) findViewById(R.id.startTimer);
		btnStartTimer.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(MainActivity.this, MyService.class);
		startService(intent);
	}

}
