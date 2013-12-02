package com.example.cameraintentdemo;

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

	private Button btnImageCapture;
	private ImageView cameraImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnImageCapture = (Button) findViewById(R.id.btnImageCapture);
		btnImageCapture.setOnClickListener(this);

		cameraImage = (ImageView) findViewById(R.id.cameraImage);

	}

	@Override
	public void onClick(View v) {
		// startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE),
		// 0);
		
		startActivityForResult(new Intent(Intent.ACTION_PICK,
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 0);
		startActivityForResult(new Intent(Intent.ACTION_PICK,
				ContactsContract.Contacts.CONTENT_URI), 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			Intent intent = new Intent(Intent.ACTION_VIEW);
			// intent.setDataAndType(data.getData(), "image/*");
			intent.setData(data.getData());
			startActivity(intent);

			// cameraImage.setImageURI(data.getData());
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

}
