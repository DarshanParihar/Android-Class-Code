package com.example.imagedownloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnDownloadData;
	private ImageView sampleImage;
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnDownloadData = (Button) findViewById(R.id.btnDownloadData);
		sampleImage = (ImageView) findViewById(R.id.image);
		progressBar = (ProgressBar) findViewById(R.id.progress);

		btnDownloadData.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		progressBar.setVisibility(View.INVISIBLE);
		sampleImage.setVisibility(View.INVISIBLE);
		new DownloadTask()
				.execute("http://cdn3.pcadvisor.co.uk/cmsdata/reviews/3475212/iPad_Air_vs_iPad_mini_2_3.jpg");
	}

	class DownloadTask extends AsyncTask<String, Void, Bitmap> {

		@Override
		protected void onPreExecute() {
			progressBar.setVisibility(View.VISIBLE);
			super.onPreExecute();
		}

		@Override
		protected Bitmap doInBackground(String... params) {
			try {
				URL url = new URL(params[0]);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.connect();
				Log.i("vipul",
						"Response Code is " + connection.getResponseCode());

				InputStream inputStream = connection.getInputStream();

				return BitmapFactory.decodeStream(inputStream);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			super.onPostExecute(result);
			sampleImage.setImageBitmap(result);
			sampleImage.setVisibility(View.VISIBLE);
			progressBar.setVisibility(View.INVISIBLE);
		}

	}
}
