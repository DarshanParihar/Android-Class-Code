package com.example.seekbarratingbardemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnSeekBarChangeListener,
		OnRatingBarChangeListener {

	private SeekBar seekBarControl;
	private RatingBar ratingBarControl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		seekBarControl = (SeekBar) findViewById(R.id.seekBarControl);
		seekBarControl.setOnSeekBarChangeListener(this);
		ratingBarControl = (RatingBar) findViewById(R.id.ratingBar);
		ratingBarControl.setOnRatingBarChangeListener(this);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		Toast.makeText(MainActivity.this,
				"Progress is " + seekBar.getProgress(), Toast.LENGTH_SHORT)
				.show();

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		Toast.makeText(MainActivity.this,
				"Progress is " + seekBar.getProgress(), Toast.LENGTH_SHORT)
				.show();

	}

	@Override
	public void onRatingChanged(RatingBar ratingBar, float rating,
			boolean fromUser) {
		Toast.makeText(MainActivity.this, "Ratings given are " + rating,
				Toast.LENGTH_SHORT).show();

		seekBarControl.setProgress((int) (rating * 20));

	}

}
