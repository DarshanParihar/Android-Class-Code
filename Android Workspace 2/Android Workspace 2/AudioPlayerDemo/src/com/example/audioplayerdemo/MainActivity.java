package com.example.audioplayerdemo;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity implements OnClickListener,
		OnSeekBarChangeListener {

	private Button btnPlay, btnPause, btnStop;
	private SeekBar volumeLevel;
	private AudioManager audioManager;
	private MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		volumeLevel = (SeekBar) findViewById(R.id.volumeLevel);
		btnPlay = (Button) findViewById(R.id.play);
		btnPause = (Button) findViewById(R.id.pause);
		btnStop = (Button) findViewById(R.id.stop);

		btnPlay.setOnClickListener(this);
		btnPause.setOnClickListener(this);
		btnStop.setOnClickListener(this);

		volumeLevel.setOnSeekBarChangeListener(this);

		audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		volumeLevel.setMax(audioManager
				.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
	}

	@Override
	protected void onResume() {
		super.onResume();

		volumeLevel.setProgress(audioManager
				.getStreamVolume(AudioManager.STREAM_MUSIC));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.play:
			if (mediaPlayer == null) {
				File file = new File("/storage/sdcard0/cocktail.mp3");
				mediaPlayer = MediaPlayer.create(MainActivity.this,
						Uri.fromFile(file));
			}
			mediaPlayer.start();
			break;
		case R.id.pause:
			mediaPlayer.pause();
			break;
		case R.id.stop:
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
			break;
		}

	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		if (fromUser)
			audioManager
					.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

}
