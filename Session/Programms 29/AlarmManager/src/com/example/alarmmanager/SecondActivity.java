package com.example.alarmmanager;

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

public class SecondActivity extends Activity {

	private TextSwitcher textSwitcher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Second Activity");
		setContentView(R.layout.activity_main);

		textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);

		textSwitcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				TextView textView = new TextView(SecondActivity.this);
				textView.setTextSize(100);
				textView.setTextColor(Color.RED);
				return textView;
			}
		});

		textSwitcher.setInAnimation(AnimationUtils.loadAnimation(
				SecondActivity.this, android.R.anim.fade_in));
		textSwitcher.setOutAnimation(AnimationUtils.loadAnimation(
				SecondActivity.this, android.R.anim.fade_out));

		CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				textSwitcher.setText("" + (millisUntilFinished / 1000));
			}

			@Override
			public void onFinish() {
				Toast.makeText(SecondActivity.this, "Time Up!!",
						Toast.LENGTH_SHORT).show();
			}
		};
		countDownTimer.start();
	}
}
