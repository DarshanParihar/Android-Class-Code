package com.example.progressdialogexample;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnSpinnerProgress, btnHorizontalProgress;
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnSpinnerProgress = (Button) findViewById(R.id.btnSpinnerProgress);
		btnHorizontalProgress = (Button) findViewById(R.id.btnHorizontalProgress);

		btnSpinnerProgress.setOnClickListener(this);
		btnHorizontalProgress.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSpinnerProgress:
			progressDialog = new ProgressDialog(this);
			progressDialog.setTitle("Please Wait!!");
			progressDialog.setMessage("Downloading File!!");
			progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progressDialog.setCancelable(false);
			progressDialog.show();

			new Thread() {
				public void run() {
					for (int i = 1; i <= 10; i++) {
						SystemClock.sleep(400);
					}

					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							if (progressDialog != null
									&& progressDialog.isShowing()) {
								progressDialog.dismiss();
							}
						}
					});
				};
			}.start();
			break;
		case R.id.btnHorizontalProgress:
			progressDialog = new ProgressDialog(this);
			progressDialog.setMessage("Downloading File");
			progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progressDialog.setMax(100);
			progressDialog.setCancelable(false);
			progressDialog.show();

			new Thread() {
				public void run() {
					for (int i = 1; i <= 10; i++) {
						runOnUiThread(new Runnable() {

							@Override
							public void run() {
								progressDialog.incrementProgressBy(10);
							}
						});

						SystemClock.sleep(400);
					}

					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							if (progressDialog != null
									&& progressDialog.isShowing()) {
								progressDialog.dismiss();
							}
						}
					});
				};
			}.start();
			break;
		}

	}
}
