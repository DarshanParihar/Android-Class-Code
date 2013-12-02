package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class MyService extends Service {

	@Override
	public void onCreate() {
		Log.i("vipul", "MyService onCreate!!!");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("vipul", "MyService onStartCommand");
		startTimer();
		return super.onStartCommand(intent, flags, startId);
	}

	public void startTimer() {
		new Thread() {
			public void run() {

				for (int i = 1; i <= 100; i += 10) {
					Log.i("vipul", "I value is " + i);
					SystemClock.sleep(400);
				}
				
				stopSelf();
			};

		}.start();
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.i("vipul", "onBind Called!!!");
		return null;
	}

	@Override
	public void onDestroy() {
		Log.i("vipul", "MyService onDestroy");
		super.onDestroy();
	}

}
