package com.example.asynctaskdemo;

import android.app.Activity;
import android.content.Context;
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

		btnStartDownload = (Button) findViewById(R.id.startDownload);
		progressBar = (ProgressBar) findViewById(R.id.progress);
		progressBar.setVisibility(View.INVISIBLE);

		btnStartDownload.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		new DownloadTask(MainActivity.this).execute();
	}

	class DownloadTask extends AsyncTask<Void, Integer, Void> {

		private Context context;

		public DownloadTask(Context context) {
			this.context = context;
		}

		@Override
		protected void onPreExecute() {
			progressBar.setVisibility(View.VISIBLE);
			btnStartDownload.setVisibility(View.INVISIBLE);
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... params) {
			for (int i = 1; i <= 10; i++) {
				publishProgress(i);
				SystemClock.sleep(400);
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			progressBar.incrementProgressBy(10);
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(Void result) {
			progressBar.setVisibility(View.INVISIBLE);
			btnStartDownload.setVisibility(View.VISIBLE);
			super.onPostExecute(result);
		}

	}

}
