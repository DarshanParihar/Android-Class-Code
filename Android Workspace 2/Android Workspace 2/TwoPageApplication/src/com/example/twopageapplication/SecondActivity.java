package com.example.twopageapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getIntent().hasExtra("name")) {
			String name = getIntent().getStringExtra("name");
			int age = getIntent().getIntExtra("age", -1);
			String location = getIntent().getStringExtra("location");

			Toast.makeText(
					SecondActivity.this,
					"Values got as follows\n" + name + "\n" + age + "\n"
							+ location, Toast.LENGTH_LONG).show();
		} else {
			int result = getIntent().getIntExtra("num1", -1)
					+ getIntent().getIntExtra("num2", -1);
			Intent data = new Intent();
			data.putExtra("result", result);
			setResult(RESULT_OK, data);
			finish();
		}
	}
}
