package com.example.zxingscanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.widget.Toast;

public class MainActivity extends Activity {
	private PowerManager powerManager;
	private WakeLock wakeLock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK,
				"vipul");

		wakeLock.acquire();
		// IntentIntegrator integrator = new IntentIntegrator(this);
		// integrator.initiateScan();
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		IntentResult scanResult = IntentIntegrator.parseActivityResult(
				requestCode, resultCode, intent);
		if (scanResult != null) {
			Toast.makeText(
					MainActivity.this,
					scanResult.getFormatName() + "\n"
							+ scanResult.getContents(), Toast.LENGTH_LONG)
					.show();
		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onPause() {
		if (wakeLock.isHeld()) {
			wakeLock.release();
		}
		super.onPause();
	}
}
