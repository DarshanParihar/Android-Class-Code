package com.example.javascriptinterfacedemo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		webView = (WebView) findViewById(R.id.webView);

		try {
			webView.getSettings().setJavaScriptEnabled(true);
			webView.addJavascriptInterface(new MyInjector(), "Vipul");
			webView.loadData(loadFromFile(), "text/html", "");
			Log.i("vipul", loadFromFile());
		} catch (Exception exception) {

		}

	}

	private String loadFromFile() throws Exception {
		InputStream inputStream = getAssets().open("sample.html");
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		String tempStr = "";
		StringBuilder stringBuilder = new StringBuilder();

		while ((tempStr = bufferedReader.readLine()) != null) {
			stringBuilder.append(tempStr);
			stringBuilder.append(System.getProperty("line.separator"));
		}

		return stringBuilder.toString();
	}

	class MyInjector {
		@JavascriptInterface
		public void showToast(String message) {
			Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT)
					.show();
		}
	}

}
