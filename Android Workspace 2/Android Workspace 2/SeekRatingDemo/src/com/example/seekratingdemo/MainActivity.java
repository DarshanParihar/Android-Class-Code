package com.example.seekratingdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnSeekBarChangeListener,
		OnRatingBarChangeListener {

	private SeekBar seekBar;
	private RatingBar ratingBar;
	private EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		seekBar = (SeekBar) findViewById(R.id.seekBar);
		seekBar.setOnSeekBarChangeListener(this);
		ratingBar = (RatingBar) findViewById(R.id.ratingBar);
		ratingBar.setOnRatingBarChangeListener(this);
		editText = (EditText) findViewById(R.id.editText);

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
		Toast.makeText(this, "Seekbar value is " + seekBar.getProgress(),
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onRatingChanged(final RatingBar rBar, float rating,
			boolean fromUser) {
		Toast.makeText(this, "Ratings are " + rating, Toast.LENGTH_SHORT)
				.show();

		if (rating == 5) {
			AlertDialog.Builder builder = new Builder(this);
			builder.setTitle("Thanks!");
			builder.setMessage("Thank you for your Feedback!!");
			builder.setPositiveButton("Dismiss",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							ratingBar.setProgress(0);
						}
					});
			builder.setNegativeButton("Cancel", null);
			builder.show();
		}

	}
}
