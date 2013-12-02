package com.example.intentactionsdemo;

import java.io.File;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button dialNumber, callNumber, shareText, viewContents;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dialNumber = (Button) findViewById(R.id.dialNumber);
		callNumber = (Button) findViewById(R.id.callNumber);
		shareText = (Button) findViewById(R.id.shareText);
		viewContents = (Button) findViewById(R.id.viewContents);

		dialNumber.setOnClickListener(this);
		callNumber.setOnClickListener(this);
		shareText.setOnClickListener(this);
		viewContents.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dialNumber:
			Intent dialIntent = new Intent(Intent.ACTION_DIAL,
					Uri.parse("tel:12345"));
			startActivity(dialIntent);
			break;
		case R.id.callNumber:
			Intent callIntent = new Intent(Intent.ACTION_CALL,
					Uri.parse("tel:12345"));
			startActivity(callIntent);
			break;
		case R.id.shareText:
			Intent shareText = new Intent(Intent.ACTION_SEND);
			shareText.setType("text/plain");
			shareText.putExtra(Intent.EXTRA_TEXT, "My Name is Vipul");
			startActivity(shareText);

			break;
		case R.id.viewContents:

			File file = new File(Environment.getExternalStorageDirectory(),
					"download/12.jpg");
			Log.i("vipul", file.getAbsolutePath());
			Intent viewIntent = new Intent(Intent.ACTION_VIEW);
			viewIntent.setDataAndType(Uri.fromFile(file), "image/*");
			startActivity(viewIntent);
			break;
		}

	}
}
