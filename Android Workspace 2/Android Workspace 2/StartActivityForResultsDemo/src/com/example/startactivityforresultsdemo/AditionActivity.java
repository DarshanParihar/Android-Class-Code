package com.example.startactivityforresultsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class AditionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		int answer = getIntent().getIntExtra("num1", 0)
				+ getIntent().getIntExtra("num2", 0);
		Intent resultIntent = new Intent();
		resultIntent.putExtra("answer", answer);
		setResult(RESULT_OK, resultIntent);
		finish();
	}
}
