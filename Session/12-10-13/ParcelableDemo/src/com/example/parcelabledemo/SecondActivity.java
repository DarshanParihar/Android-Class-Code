package com.example.parcelabledemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Employee employee = getIntent().getParcelableExtra("emp");

		Log.i("vipul", "Employee Name " + employee.getEmpName());
		Log.i("vipul", "Employee Age " + employee.getEmpAge());
		Log.i("vipul", "Employee Location " + employee.getEmpLocation());

	}

}
