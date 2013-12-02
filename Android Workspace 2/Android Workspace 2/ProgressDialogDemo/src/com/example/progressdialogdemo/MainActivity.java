package com.example.progressdialogdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnShowIndeterminateDialog, btnShowDeterminateDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnShowIndeterminateDialog = (Button) findViewById(R.id.btnShowInDeterminateDialog);
		btnShowDeterminateDialog = (Button) findViewById(R.id.btnShowDeterminateDialog);

		btnShowDeterminateDialog.setOnClickListener(this);
		btnShowIndeterminateDialog.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnShowDeterminateDialog:

			final ProgressDialog determinateDialog = new ProgressDialog(
					MainActivity.this);
			determinateDialog.setMessage("Please Wait!!");
			determinateDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			determinateDialog.setMax(100);
			determinateDialog.show();
			new Thread() {
				public void run() {
					for (int i = 0; i <= 100; i += 10) {
						SystemClock.sleep(300);
						determinateDialog.setProgress(i);
					}

					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							if (determinateDialog != null
									&& determinateDialog.isShowing())
								determinateDialog.dismiss();

						}
					});
				};
			}.start();

			break;

		case R.id.btnShowInDeterminateDialog:
			final ProgressDialog inDeterminateDialog = new ProgressDialog(
					MainActivity.this);
			inDeterminateDialog.setMessage("Please Wait!!");
			inDeterminateDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			inDeterminateDialog.show();
			new Thread() {
				public void run() {
					for (int i = 0; i <= 100; i += 10) {
						SystemClock.sleep(300);
					}

					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							if (inDeterminateDialog != null
									&& inDeterminateDialog.isShowing())
								inDeterminateDialog.dismiss();

						}
					});
				};
			}.start();

			break;
		}

	}

}
