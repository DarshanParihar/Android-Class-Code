package com.example.gallerypickdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private ImageView imageView;
	private Button btnPickImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnPickImage = (Button) findViewById(R.id.pickImage);
		imageView = (ImageView) findViewById(R.id.imageView);

		btnPickImage.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(Intent.ACTION_PICK,
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		// imageView.setImageURI(data.getData());

		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(data.getData(), "image/*");
		startActivity(intent);
	}
}
