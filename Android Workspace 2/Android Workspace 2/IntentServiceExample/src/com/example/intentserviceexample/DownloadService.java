package com.example.intentserviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

public class DownloadService extends IntentService {

	public DownloadService() {
		super("DownloadService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		String url = intent.getStringExtra("url");
		Log.i("vipul", "URL is " + url);

		for (int i = 1; i <= 10; i++) {
			Intent downloadPercentIntent = new Intent("com.vipul.download");
			downloadPercentIntent.putExtra("percent", i * 10);
			sendBroadcast(downloadPercentIntent);
			SystemClock.sleep(500);
		}

	}

}
