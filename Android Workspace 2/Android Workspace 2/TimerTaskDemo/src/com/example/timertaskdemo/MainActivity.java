package com.example.timertaskdemo;

import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	private TextSwitcher countDownText;
	private TimerTask timerTask;
	private int count = 0;
	private CountDownTimer countDownTimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		countDownText = (TextSwitcher) findViewById(R.id.countDownText);

		countDownText.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				TextView textView = new TextView(MainActivity.this);
				textView.setTextAppearance(MainActivity.this,
						android.R.style.TextAppearance_Large);
				textView.setTextColor(Color.RED);
				return textView;
			}
		});

		countDownText.setInAnimation(AnimationUtils.loadAnimation(
				MainActivity.this, android.R.anim.fade_out));

		countDownText.setOutAnimation(AnimationUtils.loadAnimation(
				MainActivity.this, android.R.anim.fade_in));

		/*
		 * timerTask = new TimerTask() {
		 * 
		 * @Override public void run() { runOnUiThread(new Runnable() {
		 * 
		 * @Override public void run() { countDownText.setText("" + (++count));
		 * } }); } };
		 * 
		 * new Timer().schedule(timerTask, 0, 1000);
		 */

		countDownTimer = new CountDownTimer(10000, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				countDownText.setText("" + (millisUntilFinished / 1000));
			}

			@Override
			public void onFinish() {
				Toast.makeText(MainActivity.this, "Time Up!!!!",
						Toast.LENGTH_SHORT).show();
			}
		};

		countDownTimer.start();
	}
}
