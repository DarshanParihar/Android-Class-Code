package com.example.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class CountdownService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		Log.i("vipul", "Service onCreate");
		super.onCreate();
		new Thread() {
			public void run() {
				for (int i = 1; i <= 10; i++) {
					Log.i("vipul", "Value is " + i);
					SystemClock.sleep(400);
				}
				stopSelf();
			};
		}.start();

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("vipul", "Service onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.i("vipul", "Service onDestroy");
		super.onDestroy();
	}

}
