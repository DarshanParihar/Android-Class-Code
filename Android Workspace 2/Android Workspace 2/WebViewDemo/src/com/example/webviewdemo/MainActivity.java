package com.example.webviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnLoadURL;
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnLoadURL = (Button) findViewById(R.id.loadUrl);
		webView = (WebView) findViewById(R.id.webView);

		btnLoadURL.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.loadUrl:

			webView.setWebViewClient(new MyWebViewClient());

			webView.loadUrl("http://developer.android.com/index.html");
		}

	}

	class MyWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			Log.i("vipul", "URL is " + url);
			if (url.contains("android")) {
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
				startActivity(intent);
				return false;
			} else {
				return true;
			}
		}
	}
}
