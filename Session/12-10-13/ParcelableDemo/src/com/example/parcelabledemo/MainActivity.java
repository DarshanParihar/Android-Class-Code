package com.example.parcelabledemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Employee employee = new Employee();
		employee.setEmpName("Vipul");
		employee.setEmpAge(27);
		employee.setEmpLocation("Thane");

		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		Bundle bundle = new Bundle();
		bundle.putParcelable("emp", employee);
		intent.putExtras(bundle);
		startActivity(intent);
	}
}
