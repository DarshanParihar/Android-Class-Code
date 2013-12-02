package com.example.twoactivityapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Second Activity");

		if (getIntent().hasExtra("username")) {
			String username = getIntent().getStringExtra("username");
			Log.i("vipul", "Username is " + username);
		}

		if (getIntent().hasExtra("password")) {
			String password = getIntent().getStringExtra("password");
			Log.i("vipul", "Password is " + password);
		}
	}
}
