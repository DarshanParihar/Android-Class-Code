package com.example.intentservicedemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnStartDownload;
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnStartDownload = (Button) findViewById(R.id.startDownload);
		progressBar = (ProgressBar) findViewById(R.id.progress);

		btnStartDownload.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(MainActivity.this, DownloadService.class);
		intent.putExtra("url", "http://www.google.com/abc.exe");
		startService(intent);
		LocalBroadcastManager.getInstance(this).registerReceiver(
				new BroadcastReceiver() {

					@Override
					public void onReceive(Context context, Intent intent) {
						if (intent.hasExtra("progress")) {
							int progress = intent.getIntExtra("progress", -1);
							Log.i("vipul", "" + progress);
							if (progress != -1) {
								progressBar.incrementProgressBy(10);
							}

							if (progress == 100) {
								progressBar.setVisibility(View.INVISIBLE);
							}
						}

					}
				}, new IntentFilter("com.example.progress"));
	}

}
