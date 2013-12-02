package com.example.imagedownloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,
		OnItemClickListener {

	private Button btnDownloadData;
	private ListView countryList;
	private ProgressBar progressBar;
	private ArrayAdapter<String> countryAdapter;
	private ArrayList<String> countryCurrencyList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnDownloadData = (Button) findViewById(R.id.btnDownloadData);
		countryList = (ListView) findViewById(R.id.countryList);
		progressBar = (ProgressBar) findViewById(R.id.progress);

		btnDownloadData.setOnClickListener(this);

		countryAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1);
		countryList.setAdapter(countryAdapter);
		countryList.setOnItemClickListener(this);
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		progressBar.setVisibility(View.INVISIBLE);
		countryList.setVisibility(View.INVISIBLE);
		new DownloadTask().execute("http://m.tripsketch.com/AsiaRegion.txt");

		new DownloadTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
				"http://m.tripsketch.com/AsiaRegion.txt");
		
		
	}

	class DownloadTask extends AsyncTask<String, Void, String> {
		String request = "";

		@Override
		protected void onPreExecute() {
			progressBar.setVisibility(View.VISIBLE);
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... params) {
			try {
				request = params[0];

				HttpClient client = new DefaultHttpClient();
				HttpGet get = new HttpGet(params[0]);
				HttpResponse response = client.execute(get);

				// URL url = new URL(params[0]);
				// HttpURLConnection connection = (HttpURLConnection) url
				// .openConnection();
				// connection.connect();
				// Log.i("vipul",
				// "Response Code is " + connection.getResponseCode());

				// InputStream inputStream = connection.getInputStream();

				InputStream inputStream = response.getEntity().getContent();

				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(inputStream));

				String tempString = "";
				StringBuilder builder = new StringBuilder();

				while ((tempString = bufferedReader.readLine()) != null) {
					builder.append(tempString);
				}

				bufferedReader.close();

				return builder.toString();

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			
			super.onPostExecute(result);
			Log.i("vipul", "Response is " + result);
			try {
				formatJsonString(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
			countryList.setVisibility(View.VISIBLE);
			progressBar.setVisibility(View.INVISIBLE);
		}

	}

	private void formatJsonString(String jsonString) throws Exception {
		countryCurrencyList = new ArrayList<String>();
		JSONObject object = new JSONObject(jsonString);

		JSONArray countryArray = object.getJSONArray("data");

		for (int i = 0; i < countryArray.length(); i++) {
			JSONObject countryObject = countryArray.getJSONObject(i);

			String cityName = countryObject.getString("name");
			String countryName = countryObject.getString("Country");
			String cityCurrency = countryObject.getString("Currency");
			countryAdapter.add(cityName + "\n" + countryName);
			countryCurrencyList.add(cityCurrency);
		}

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		Toast.makeText(this,
				"Currency is " + countryCurrencyList.get(position),
				Toast.LENGTH_SHORT).show();

	}
}
