package com.example.intentservice;

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

	private ProgressBar progressBar;
	private Button btnStartCounting;
	private CountReceiver countReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		btnStartCounting = (Button) findViewById(R.id.btnstartCounting);

		progressBar.setVisibility(View.INVISIBLE);
		progressBar.setMax(100);

		btnStartCounting.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(MainActivity.this, CountingService.class);
		countReceiver = new CountReceiver();
		LocalBroadcastManager.getInstance(this).registerReceiver(countReceiver,
				new IntentFilter("com.dummy.count"));
		progressBar.setVisibility(View.VISIBLE);
		btnStartCounting.setVisibility(View.INVISIBLE);
		startService(intent);

	}

	class CountReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			Log.i("vipul", "Received Broadcast");
			int count = intent.getIntExtra("count", -1);
			progressBar.incrementProgressBy(10);

			if (count == 10) {
				progressBar.setVisibility(View.INVISIBLE);
				btnStartCounting.setVisibility(View.VISIBLE);
				progressBar.setProgress(0);
			}

		}
	}

}
