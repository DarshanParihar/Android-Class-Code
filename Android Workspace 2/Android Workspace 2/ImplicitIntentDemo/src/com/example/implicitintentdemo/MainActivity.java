package com.example.implicitintentdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnDialNumber, btnCallNumber, btnShareText, btnViewContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnDialNumber = (Button) findViewById(R.id.dialNumber);
		btnCallNumber = (Button) findViewById(R.id.callNumber);
		btnShareText = (Button) findViewById(R.id.shareText);
		btnViewContent = (Button) findViewById(R.id.viewContent);

		btnDialNumber.setOnClickListener(this);
		btnCallNumber.setOnClickListener(this);
		btnShareText.setOnClickListener(this);
		btnViewContent.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dialNumber:
			Intent dialIntent = new Intent();
			dialIntent.setAction(Intent.ACTION_DIAL);
			dialIntent.setData(Uri.parse("tel:1234"));
			startActivity(dialIntent);
			break;
		case R.id.callNumber:
			Intent callIntent = new Intent();
			callIntent.setAction(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:1234"));
			startActivity(callIntent);
			break;
		case R.id.shareText:
			Intent shareIntent = new Intent();
			shareIntent.setAction(Intent.ACTION_SEND);
			shareIntent.putExtra(Intent.EXTRA_TEXT, "This is sample Text!!!");
			shareIntent.setType("text/plain");
			startActivity(shareIntent);
		case R.id.viewContent:
			Intent viewIntent = new Intent();
			viewIntent.setAction(Intent.ACTION_VIEW);
			viewIntent.setData(ContactsContract.Contacts.CONTENT_URI);
			startActivity(viewIntent);
		}

	}
}
