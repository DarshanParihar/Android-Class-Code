package com.example.powermanagerdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnAcquireLock, btnReleaseLock;
	private PowerManager powerManager;
	private WakeLock wakeLock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnAcquireLock = (Button) findViewById(R.id.holdLock);
		btnReleaseLock = (Button) findViewById(R.id.releaseLock);

		btnAcquireLock.setOnClickListener(this);
		btnReleaseLock.setOnClickListener(this);

		powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK,
				"myWakeLock");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.holdLock:
			wakeLock.acquire();
			break;
		case R.id.releaseLock:
			wakeLock.release();
			break;
		}

	}

	@Override
	protected void onPause() {
		if (wakeLock.isHeld()) {
			wakeLock.release();
		}
		super.onPause();
	}
}
