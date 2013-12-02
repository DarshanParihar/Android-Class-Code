package com.example.audiomanagerdemo;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnSeekBarChangeListener {

	private SeekBar audioSeekBar;
	private TextView audioLevel;
	private AudioManager audioManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		audioLevel = (TextView) findViewById(R.id.audioLevel);
		audioSeekBar = (SeekBar) findViewById(R.id.audioSeekBar);

		audioSeekBar.setOnSeekBarChangeListener(this);

		audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

	}

	@Override
	protected void onResume() {
		super.onResume();

		int maxVolume = audioManager
				.getStreamMaxVolume(AudioManager.STREAM_MUSIC); // take device
																// max volume
		audioSeekBar.setMax(maxVolume);
		int currentVolume = audioManager
				.getStreamVolume(AudioManager.STREAM_MUSIC); // take device
																// current
																// volume
		audioSeekBar.setProgress(currentVolume);
		audioLevel.setText("Current volume is " + (currentVolume * 100)
				/ maxVolume);

	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		if (fromUser) {
			audioManager
					.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
			audioLevel.setText("Current volume is "
					+ (progress * 100)
					/ audioManager
							.getStreamMaxVolume(AudioManager.STREAM_MUSIC));

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
