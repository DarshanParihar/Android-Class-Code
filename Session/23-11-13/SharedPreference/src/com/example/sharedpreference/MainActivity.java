package com.example.sharedpreference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	private SharedPreferences preferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		preferences = getSharedPreferences("E_up", Context.MODE_PRIVATE);

		if (preferences.contains("username")) {
			Log.i("vipul",
					"Username is " + preferences.getString("username", ""));
			Log.i("vipul",
					"Password is " + preferences.getString("password", ""));
		} else {
			Log.i("vipul", "No Data");
		}

		preferences.edit().putString("username", "VIPUL").commit();
		
		preferences.edit().putString("password", "SHAH").commit();

	}

}
