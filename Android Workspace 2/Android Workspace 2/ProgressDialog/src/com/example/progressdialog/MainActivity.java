package com.example.progressdialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnStartDownload;
	private ProgressDialog progressDialog;
	private Spinner spinnerProgressDialogType;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnStartDownload = (Button) findViewById(R.id.startDownload);
		btnStartDownload.setOnClickListener(this);
		spinnerProgressDialogType = (Spinner) findViewById(R.id.progressDialogType);
	}

	@Override
	public void onClick(View v) {
		if (spinnerProgressDialogType.getSelectedItemPosition() == 0) {
			progressDialog = new ProgressDialog(MainActivity.this);
			progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progressDialog.setMax(100);
			progressDialog.setCancelable(false);
			progressDialog.setTitle("Please Wait");
			progressDialog.setMessage("Downloading File");
			progressDialog.show();

			new Thread() {
				public void run() {
					for (int i = 10; i <= 100; i += 10) {
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

		} else {
			progressDialog = new ProgressDialog(MainActivity.this);
			progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progressDialog.setMax(100);
			progressDialog.setCancelable(false);
			progressDialog.setTitle("Please Wait");
			progressDialog.setMessage("Downloading File");
			progressDialog.show();

			new Thread() {
				public void run() {
					for (int i = 10; i <= 100; i += 10) {
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
		}
	}
}
