package com.example.videoviewexample;

import java.io.File;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

	private VideoView videoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		videoView = (VideoView) findViewById(R.id.videoView);
		File file = new File(Environment.getExternalStorageDirectory(),
				"/Download/sample.mp4");
		videoView.setVideoURI(Uri.fromFile(file));
		videoView.setMediaController(new MediaController(this));
	}
}
