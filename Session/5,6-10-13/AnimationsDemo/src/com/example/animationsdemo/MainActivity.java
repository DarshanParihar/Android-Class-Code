package com.example.animationsdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button btnAlphaAnimation, btnRotateAnimation,
			btnTranslateAnimation, btnScaleAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnAlphaAnimation = (Button) findViewById(R.id.btnAlphaAnimation);
		btnRotateAnimation = (Button) findViewById(R.id.btnRotateAnimation);
		btnTranslateAnimation = (Button) findViewById(R.id.btnTranslateAnimation);
		btnScaleAnimation = (Button) findViewById(R.id.btnScaleAnimation);

		btnAlphaAnimation.setOnClickListener(this);
		btnRotateAnimation.setOnClickListener(this);
		btnTranslateAnimation.setOnClickListener(this);
		btnScaleAnimation.setOnClickListener(this);
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnAlphaAnimation:
			btnAlphaAnimation.animate().alphaBy(-1).setDuration(600).start();
			break;
		case R.id.btnRotateAnimation:
			btnRotateAnimation.animate().rotationBy(270).setDuration(600)
					.start();
			break;
		case R.id.btnTranslateAnimation:
			btnTranslateAnimation.animate().translationX(100).setDuration(600)
					.start();
			break;
		case R.id.btnScaleAnimation:
			btnScaleAnimation.animate().scaleXBy(2).setDuration(600).start();
			break;
		}

	}
}
