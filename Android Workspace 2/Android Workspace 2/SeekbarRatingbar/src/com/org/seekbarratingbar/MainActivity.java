package com.org.seekbarratingbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnSeekBarChangeListener,
		OnRatingBarChangeListener {

	private SeekBar seekBar;
	private RatingBar ratingBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		seekBar = (SeekBar) findViewById(R.id.seekBar);
		seekBar.setOnSeekBarChangeListener(this);

		ratingBar = (RatingBar) findViewById(R.id.ratingBar);
		ratingBar.setOnRatingBarChangeListener(this);

	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		Toast.makeText(MainActivity.this,
				"Seek value is " + seekBar.getProgress(), Toast.LENGTH_SHORT)
				.show();
		if (seekBar.getProgress() > 50) {
			ratingBar.setProgress(10);
		}
	}

	@Override
	public void onRatingChanged(RatingBar ratingBar, float rating,
			boolean fromUser) {
		Toast.makeText(MainActivity.this,
				"Ratings are " + rating + " from user " + fromUser,
				Toast.LENGTH_SHORT).show();
	}

}
