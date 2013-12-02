package com.example.imagepickerdemo;

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

	private Button btnPickImage, btnPickContact;
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnPickImage = (Button) findViewById(R.id.pickImage);
		imageView = (ImageView) findViewById(R.id.imageView);
		btnPickContact = (Button) findViewById(R.id.pickContact);
		btnPickContact.setOnClickListener(this);

		btnPickImage.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.pickContact:
			Intent contactIntent = new Intent(Intent.ACTION_PICK,
					ContactsContract.Contacts.CONTENT_URI);
			startActivityForResult(contactIntent, 0);
			break;
		case R.id.pickImage:
			Intent intent = new Intent(Intent.ACTION_PICK,
					MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(intent, 1);
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {
			if (resultCode == RESULT_OK) {
				imageView.setImageURI(data.getData());
			}
		}
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				Intent intent = new Intent(Intent.ACTION_VIEW, data.getData());
				startActivity(intent);
			}
		}

		super.onActivityResult(requestCode, resultCode, data);
	}
}
