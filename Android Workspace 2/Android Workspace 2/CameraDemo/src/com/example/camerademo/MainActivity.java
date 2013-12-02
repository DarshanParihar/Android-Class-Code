package com.example.camerademo;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private ImageView imageView;
	private Button btnCapture;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imageView = (ImageView) findViewById(R.id.imageView);
		btnCapture = (Button) findViewById(R.id.btnCapture);
		btnCapture.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		File path = Environment.getExternalStorageDirectory();
		File file = new File(path, "/Music/temp.jpg");
		Uri outputFileUri = Uri.fromFile(file);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Bitmap bitmap = (Bitmap) data.getExtras().get("data");
		imageView.setImageBitmap(bitmap);
		super.onActivityResult(requestCode, resultCode, data);

	}
}
