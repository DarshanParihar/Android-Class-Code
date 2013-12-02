package com.example.mediaplayerdemo;

import java.io.File;
import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener,
		OnSeekBarChangeListener {

	private Button btnPlay, btnPause, btnStop;
	private MediaPlayer mediaPlayer;
	private SeekBar mediaProgress;
	private Handler handler;
	private Runnable runnable;
	private TextView ellapsedTime, remainingTime;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnPlay = (Button) findViewById(R.id.play);
		btnPause = (Button) findViewById(R.id.pause);
		btnStop = (Button) findViewById(R.id.stop);

		btnPlay.setOnClickListener(this);
		btnPause.setOnClickListener(this);
		btnStop.setOnClickListener(this);

		mediaProgress = (SeekBar) findViewById(R.id.mediaProgress);
		mediaProgress.setOnSeekBarChangeListener(this);

		ellapsedTime = (TextView) findViewById(R.id.ellapsedTime);
		remainingTime = (TextView) findViewById(R.id.remainingTime);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
			getActionBar();

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.play:
			if (mediaPlayer == null) {
				File audioFile = new File("/storage/sdcard0/cocktail.mp3");
				Log.i("vipul",
						audioFile.getAbsolutePath() + " " + audioFile.length());
				mediaPlayer = MediaPlayer.create(MainActivity.this,
						Uri.fromFile(audioFile));
				mediaProgress.setMax(mediaPlayer.getDuration());

				handler = new Handler();

				runnable = new Runnable() {

					@Override
					public void run() {
						mediaProgress.setProgress(mediaPlayer
								.getCurrentPosition());
						long rt = mediaPlayer.getDuration()
								- mediaPlayer.getCurrentPosition();
						long et = mediaPlayer.getDuration() - rt;

						ellapsedTime.setText(getmmss(et));
						remainingTime.setText(getmmss(rt));

						handler.postDelayed(runnable, 1000);

					}
				};

				handler.post(runnable);
			}
			mediaPlayer.start();
			break;
		case R.id.pause:
			mediaPlayer.pause();
			break;
		case R.id.stop:
			handler.removeCallbacks(runnable);
			mediaProgress.setProgress(0);
			remainingTime.setText(getmmss(mediaPlayer.getDuration()));
			ellapsedTime.setText(getmmss(0));
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
			break;
		}

	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		if (fromUser) {
			mediaPlayer.seekTo(progress);
		}
		if (progress == mediaPlayer.getDuration()) {
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
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

	@SuppressLint("NewApi")
	private String getmmss(long ms) {
		return String.format(
				"%02d:%02d",

				TimeUnit.MILLISECONDS.toMinutes(ms)
						- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
								.toHours(ms)),
				TimeUnit.MILLISECONDS.toSeconds(ms)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
								.toMinutes(ms)));
	}

}
