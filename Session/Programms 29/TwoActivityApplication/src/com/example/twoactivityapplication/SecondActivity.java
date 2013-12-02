package com.example.twoactivityapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Second Activity");

		int num1 = getIntent().getIntExtra("num1", 0);
		int num2 = getIntent().getIntExtra("num2", 0);

		int answer = num1 + num2;

		Intent intent = new Intent();
		intent.putExtra("answer", answer);
		if (answer > 0)
			setResult(RESULT_OK, intent);
		else
			setResult(RESULT_CANCELED, intent);
		finish();

	}

}
