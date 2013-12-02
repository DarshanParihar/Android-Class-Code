package com.example.webviewjavascriptinjection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private WebView webView;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		webView = (WebView) findViewById(R.id.webview);
		try {
			webView.getSettings().setJavaScriptEnabled(true);
			webView.addJavascriptInterface(new MyInjector(), "Vipul");
			webView.loadData(getAssetFileData(), "text/html", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getAssetFileData() throws Exception {
		String temp = "";
		StringBuilder builder = new StringBuilder();
		InputStream inputStream = getAssets().open("sample.html");
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));

		while ((temp = bufferedReader.readLine()) != null) {
			builder.append(temp);
			builder.append(System.getProperty("line.separator"));
		}

		return builder.toString();
	}

	class MyInjector {

		@JavascriptInterface
		public void showAndroidToast(String message) {
			Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT)
					.show();
		}

		@JavascriptInterface
		public void showiOSToast(String message) {
			Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT)
					.show();
		}
	}

}
