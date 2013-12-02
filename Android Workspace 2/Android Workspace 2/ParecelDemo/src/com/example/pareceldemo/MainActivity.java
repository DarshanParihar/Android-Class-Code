package com.example.pareceldemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);

		Employee employee = new Employee();
		employee.setEmpName("Vipul");
		employee.setEmpAge(27);
		employee.setEmpCompany("vserv.mobi");

		Intent intent = new Intent(this, SecondActivity.class);
		Bundle bundle = new Bundle();
		bundle.putParcelable("emp", employee);
		intent.putExtras(bundle);
		startActivity(intent);
	}
}
