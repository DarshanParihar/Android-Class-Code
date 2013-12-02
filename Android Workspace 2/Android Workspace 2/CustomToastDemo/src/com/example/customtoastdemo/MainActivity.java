package com.example.customtoastdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Toast toast = new Toast(this);
		toast.setView(getLayoutInflater().inflate(R.layout.activity_main, null));
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();

	}

}
