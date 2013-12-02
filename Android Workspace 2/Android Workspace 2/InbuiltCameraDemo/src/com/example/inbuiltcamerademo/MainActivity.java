package com.example.inbuiltcamerademo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private Button btncaptureImage;
	private ImageView imgView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imgView = (ImageView) findViewById(R.id.imageView);
		btncaptureImage = (Button) findViewById(R.id.captureImage);
		btncaptureImage.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//		Intent intent = new Intent(Intent.ACTION_PICK,
//				ContactsContract.Contacts.CONTENT_URI);
//		Intent intent = new Intent(Intent.ACTION_PICK,
//				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		startActivityForResult(intent, 0);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				// imgView.setImageURI(data.getData());
				Intent intent = new Intent(Intent.ACTION_VIEW, data.getData());
				startActivity(intent);
			}
		}
	}
}
