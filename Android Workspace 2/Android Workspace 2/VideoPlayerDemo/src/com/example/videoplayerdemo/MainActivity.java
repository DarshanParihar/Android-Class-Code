package com.example.videoplayerdemo;

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

		videoView.setVideoURI(Uri.fromFile(new File(Environment
				.getExternalStorageDirectory(), "video.mp4")));
		videoView.setMediaController(new MediaController(this));
		videoView.requestFocus();
	}
}
