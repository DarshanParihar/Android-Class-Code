package com.example.twopageapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnSwitchToNext,btnStartActivityForResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("First Activity");
		setContentView(R.layout.activity_main);

		btnSwitchToNext = (Button) findViewById(R.id.btnSwitchToNext);
		btnSwitchToNext.setOnClickListener(this);
		
		btnStartActivityForResult = (Button) findViewById(R.id.btnStartActivityForResult);
		btnStartActivityForResult.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btnSwitchToNext) {
			String name = "Vipul";
			int age = 27;
			String location = "Thane";

			Intent intent = new Intent(MainActivity.this, SecondActivity.class);
			intent.putExtra("name", name);
			intent.putExtra("age", age);
			intent.putExtra("location", location);

			startActivity(intent);
		} else {
			int num1 = 10;
			int num2 = 20;

			Intent intent = new Intent(MainActivity.this, SecondActivity.class);
			intent.putExtra("num1", num1);
			intent.putExtra("num2", num2);
			startActivityForResult(intent, 0);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			int result = data.getIntExtra("result", -1);
			Toast.makeText(MainActivity.this, "Result is " + result,
					Toast.LENGTH_SHORT).show();
		}
	}
}
