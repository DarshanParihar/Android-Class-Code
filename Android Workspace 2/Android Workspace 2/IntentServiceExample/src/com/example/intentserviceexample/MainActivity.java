package com.example.intentserviceexample;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ProgressBar downloadProgress;
	private DownloadReceiver downloadReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		downloadProgress = (ProgressBar) findViewById(R.id.downloadProgress);

		downloadReceiver = new DownloadReceiver();

		((Button) findViewById(R.id.download))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						downloadProgress.setVisibility(View.VISIBLE);
						downloadProgress.setProgress(0);
						Intent intent = new Intent(MainActivity.this,
								DownloadService.class);
						registerReceiver(downloadReceiver, new IntentFilter(
								"com.vipul.download"));
						intent.putExtra("url", "http://www.google.com");
						startService(intent);
					}
				});
	}

	class DownloadReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			int downloadPercent = intent.getIntExtra("percent", -1);

			if (downloadPercent != -1) {
				if (downloadPercent == 100) {
					downloadProgress.setVisibility(View.INVISIBLE);
					Toast.makeText(MainActivity.this, "Download Complete!!",
							Toast.LENGTH_SHORT).show();
				} else {
					downloadProgress.setProgress(downloadPercent);
				}
			}
		}
	}

	@Override
	protected void onDestroy() {
		if (downloadReceiver != null) {
			unregisterReceiver(downloadReceiver);
			downloadReceiver = null;
		}
		super.onDestroy();
	}
}
