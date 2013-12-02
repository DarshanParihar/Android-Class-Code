package com.example.wakelockdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

public class MainActivity extends Activity {

	private PowerManager powerManager;
	private PowerManager.WakeLock wakeLock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK,
				"vipul");
	}

	@Override
	protected void onResume() {
		super.onResume();

		wakeLock.acquire();
	}

	@Override
	protected void onStop() {
		super.onStop();
		wakeLock.release();
	}

}
