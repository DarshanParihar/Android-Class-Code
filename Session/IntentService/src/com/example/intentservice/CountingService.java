package com.example.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;

public class CountingService extends IntentService {

	public CountingService() {
		super("CountingService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
			for (int i = 1; i <= 10; i++) {
				Intent countIntent = new Intent();
				countIntent.putExtra("count", i);
				countIntent.setAction("com.dummy.count");
				LocalBroadcastManager.getInstance(this).sendBroadcast(countIntent);
				SystemClock.sleep(400);
			}
	}
}
