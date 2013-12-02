package com.example.videoviewdemo;

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
		videoView.setMediaController(new MediaController(this));
		File videoFile = new File(Environment.getExternalStorageDirectory(),
				"/Video/Sample.mp4");
		videoView.setVideoURI(Uri.fromFile(videoFile));
		videoView.start();
	}

}
