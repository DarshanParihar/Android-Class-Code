package com.example.sharedpreferencedemo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnSubmit;
	private EditText txtName, txtAge;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtName = (EditText) findViewById(R.id.txtName);
		txtAge = (EditText) findViewById(R.id.txtAge);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(this);

	}

	@Override
	protected void onResume() {
		super.onResume();

		SharedPreferences preferences = getSharedPreferences("employee_info",
				Context.MODE_PRIVATE);
		if (preferences.contains("name")) {
			txtName.setText(preferences.getString("name", ""));
		}
		if (preferences.contains("age")) {
			txtAge.setText(preferences.getString("age", ""));
		}
	}

	@Override
	public void onClick(View v) {
		SharedPreferences.Editor editor = getSharedPreferences("employee_info",
				Context.MODE_PRIVATE).edit();
		editor.putString("name", txtName.getText().toString());
		editor.putString("age", txtAge.getText().toString());
		editor.commit();
	}
}
