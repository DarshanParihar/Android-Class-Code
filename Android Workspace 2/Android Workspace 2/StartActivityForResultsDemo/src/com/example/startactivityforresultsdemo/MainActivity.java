package com.example.startactivityforresultsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	private static final int ADDTION_REQUEST_CODE = 1;
	private static final int MULTIPLY_REQUEST_CODE = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		int a = 10, b = 20;

		Intent additionIntent = new Intent(MainActivity.this,
				AditionActivity.class);
		additionIntent.putExtra("num1", a);
		additionIntent.putExtra("num2", b);
		startActivityForResult(additionIntent, ADDTION_REQUEST_CODE);

		Intent multiplyIntent = new Intent(MainActivity.this,
				MultiplyActivity.class);
		multiplyIntent.putExtra("num1", a);
		multiplyIntent.putExtra("num2", b);
		startActivityForResult(multiplyIntent, MULTIPLY_REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == ADDTION_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				Log.i("vipul", "Addition is " + data.getIntExtra("answer", -1));
			} else {

			}
		}
		if (requestCode == MULTIPLY_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				Log.i("vipul",
						"Multiplication is " + data.getIntExtra("answer", -1));
			} else {

			}
		}
	}
}
