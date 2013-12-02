package com.example.mediaplayer;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity implements OnClickListener,
		OnSeekBarChangeListener {

	private SeekBar audioVolume, songProgress;
	private Button btnPlay, btnPause, btnStop;
	private AudioManager audioManager;
	private MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

		audioVolume = (SeekBar) findViewById(R.id.audioVolume);
		songProgress = (SeekBar) findViewById(R.id.songProgress);

		audioVolume.setMax(audioManager
				.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
		audioVolume.setOnSeekBarChangeListener(this);
		songProgress.setOnSeekBarChangeListener(this);

		btnPlay = (Button) findViewById(R.id.play);
		btnPause = (Button) findViewById(R.id.pause);
		btnStop = (Button) findViewById(R.id.stop);

		btnPlay.setOnClickListener(this);
		btnPause.setOnClickListener(this);
		btnStop.setOnClickListener(this);
	}

	@Override
	protected void onResume() {
		audioVolume.setProgress(audioManager
				.getStreamVolume(AudioManager.STREAM_MUSIC));
		super.onResume();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.play:
			if (mediaPlayer == null) {
				File audioFile = new File("/storage/sdcard0/cocktail.mp3");
				mediaPlayer = MediaPlayer.create(MainActivity.this,
						Uri.fromFile(audioFile));
				songProgress.setMax(mediaPlayer.getDuration());
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
		if (seekBar.getId() == R.id.audioVolume) {
			audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,
					AudioManager.FLAG_PLAY_SOUND);
		} else {
			if (mediaPlayer != null) {
				mediaPlayer.seekTo(progress);
			}
		}
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
