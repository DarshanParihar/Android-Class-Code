package com.example.intentservicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class DownloadService extends IntentService {

	public DownloadService() {
		super("Download Service");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		String url = intent.getStringExtra("url");
		Log.i("vipul", "URL is " + url);

		for (int i = 10; i <= 100; i+=10) {
			Intent broadcastIntent=new Intent("com.example.progress");
			broadcastIntent.putExtra("progress",i);
			LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent);
			SystemClock.sleep(400);
		}

	}
}
