package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.linear_activity_main);
		showLog("onCreate");
	}

	@Override
	protected void onStart() {
		showLog("onStart");
		super.onStart();
	}

	@Override
	protected void onResume() {
		showLog("onResume");
		super.onResume();
	}

	@Override
	protected void onPause() {
		showLog("onPause");
		super.onPause();
	}

	@Override
	protected void onStop() {
		showLog("onStop");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		showLog("onDestroy");
		super.onDestroy();
	}

	private void showLog(String message) {
		Log.i("vipul", message);
	}
}
