package com.example.intentactiondemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button showDial, startCall, openWebPage, shareText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		showDial = (Button) findViewById(R.id.showDial);
		startCall = (Button) findViewById(R.id.initiateCall);
		openWebPage = (Button) findViewById(R.id.browseWeb);
		shareText = (Button) findViewById(R.id.share);

		showDial.setOnClickListener(this);
		startCall.setOnClickListener(this);
		openWebPage.setOnClickListener(this);
		shareText.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.showDial) {
			startActivity(new Intent(Intent.ACTION_DIAL,
					Uri.parse("tel:123456")));

		} else if (v.getId() == R.id.initiateCall) {
			startActivity(new Intent(Intent.ACTION_CALL,
					Uri.parse("tel:123456")));

		} else if (v.getId() == R.id.browseWeb) {
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.google.com")));

		} else if (v.getId() == R.id.share) {
			String text = "Sample Text";
			Intent shareIntent = new Intent(Intent.ACTION_SEND);
			shareIntent.putExtra(Intent.EXTRA_TEXT, text);
			shareIntent.setType("text/plain");
			startActivity(shareIntent);

		}
	}
}
