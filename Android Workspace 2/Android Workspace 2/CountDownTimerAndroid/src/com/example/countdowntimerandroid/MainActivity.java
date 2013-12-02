package com.example.countdowntimerandroid;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView txtClock;
	private CountDownTimer countDownTimer;
	private int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtClock = (TextView) findViewById(R.id.txtClock);

		/*
		 * countDownTimer = new CountDownTimer(10000, 1000) {
		 * 
		 * @Override public void onTick(long millisUntilFinished) {
		 * 
		 * txtClock.setText("" + (int)(10000 - millisUntilFinished) / 1000); }
		 * 
		 * @Override public void onFinish() { txtClock.setText("Your Time Up");
		 * 
		 * } };
		 * 
		 * // countDownTimer.start();
		 */

		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				final int answer = ++i;

				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						txtClock.setText("" + answer);
					}
				});
			}
		}, 0, 1000);

	}

}
