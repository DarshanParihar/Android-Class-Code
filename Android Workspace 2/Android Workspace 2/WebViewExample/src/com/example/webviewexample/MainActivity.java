package com.example.webviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements
		RadioGroup.OnCheckedChangeListener,
		CompoundButton.OnCheckedChangeListener {

	private WebView webView;
	private RadioGroup siteGroup;
	private CheckBox chkCricket, chkHockey, chkFootball;
	private ToggleButton toggleButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		siteGroup = (RadioGroup) findViewById(R.id.siteGroup);
		siteGroup.setOnCheckedChangeListener(this);

		webView = (WebView) findViewById(R.id.webView);
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;

			}
		});

		chkCricket = (CheckBox) findViewById(R.id.cricket);
		chkHockey = (CheckBox) findViewById(R.id.hockey);
		chkFootball = (CheckBox) findViewById(R.id.football);

		chkCricket.setOnCheckedChangeListener(this);
		chkHockey.setOnCheckedChangeListener(this);
		chkFootball.setOnCheckedChangeListener(this);

		toggleButton = (ToggleButton) findViewById(R.id.toggle);
		toggleButton.setOnCheckedChangeListener(this);

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.google) {
			webView.loadUrl("http://www.google.com");
		} else {
			webView.loadUrl("http://www.yahoo.com");
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		case R.id.cricket:
			if (isChecked) {
				Toast.makeText(MainActivity.this,
						buttonView.getText() + " is Checked",
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(MainActivity.this,
						buttonView.getText() + " is Unchecked",
						Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.football:
			if (isChecked) {
				Toast.makeText(MainActivity.this,
						buttonView.getText() + " is Checked",
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(MainActivity.this,
						buttonView.getText() + " is Unchecked",
						Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.hockey:
			if (isChecked) {
				Toast.makeText(MainActivity.this,
						buttonView.getText() + " is Checked",
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(MainActivity.this,
						buttonView.getText() + " is Unchecked",
						Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.toggle:
			if (buttonView.getText().equals("No"))
				Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT)
						.show();
			else
				Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT)
						.show();
		}

	}
}
