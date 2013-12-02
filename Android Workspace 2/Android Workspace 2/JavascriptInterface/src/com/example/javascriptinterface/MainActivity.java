package com.example.javascriptinterface;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		webView = (WebView) findViewById(R.id.webview);
		try {
			webView.getSettings().setJavaScriptEnabled(true);
			webView.loadData(loadFileData(), "text/html", "");
			webView.addJavascriptInterface(new MyInjector(), "Vipul");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String loadFileData() throws Exception {
		String tempString = "";
		StringBuilder builder = new StringBuilder();
		InputStream inputStream = getAssets().open("sample.html");
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		while ((tempString = bufferedReader.readLine()) != null) {
			builder.append(tempString);
			builder.append("\n");
		}

		return builder.toString();
	}

	class MyInjector {
		@JavascriptInterface
		public void showToast(String message) {
			Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT)
					.show();
		}
	}
}
