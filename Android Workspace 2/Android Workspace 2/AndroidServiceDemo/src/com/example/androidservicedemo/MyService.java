package com.example.androidservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		Log.i("vipul", "Service Started!!!");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("vipul", "onStartCommand Called!");
		new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					Log.i("vipul", "I value is " + i);
					SystemClock.sleep(300);
				}
				stopSelf();
			};
		}.start();

		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		Log.i("vipul", "Service finished");
		super.onDestroy();
	}
}
