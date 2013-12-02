package com.example.asynctaskexample;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
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

		btnStartDownload = (Button) findViewById(R.id.btnStartDownload);
		progressBar = (ProgressBar) findViewById(R.id.progress);
		progressBar.setVisibility(View.INVISIBLE);
		btnStartDownload.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		new CountingTask().execute("");
	}

	class CountingTask extends AsyncTask<String, Integer, Void> {

		@Override
		protected void onPreExecute() {
			progressBar.setMax(100);
			progressBar.setProgress(0);
			btnStartDownload.setVisibility(View.INVISIBLE);
			progressBar.setVisibility(View.VISIBLE);
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(String... params) {
			for (int i = 1; i < 10; i++) {
				publishProgress(i);
				SystemClock.sleep(500);
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			progressBar.incrementProgressBy(10);
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);

			progressBar.setVisibility(View.INVISIBLE);
			btnStartDownload.setVisibility(View.VISIBLE);
		}

	}

}
