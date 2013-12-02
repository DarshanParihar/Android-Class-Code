package com.example.pareceldemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);

		Bundle bundle = getIntent().getExtras();
		Employee employee = bundle.getParcelable("emp");
		Log.i("vipul", employee.getEmpName());
		Log.i("vipul", "" + employee.getEmpAge());
		Log.i("vipul", employee.getEmpCompany());

	}
}
