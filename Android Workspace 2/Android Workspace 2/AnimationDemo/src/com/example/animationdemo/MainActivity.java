package com.example.animationdemo;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnAlpha, btnRotate, btnTranslate, btnScale;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnAlpha = (Button) findViewById(R.id.btnAlpha);
		btnRotate = (Button) findViewById(R.id.btnRotate);
		btnTranslate = (Button) findViewById(R.id.btnTranslate);
		btnScale = (Button) findViewById(R.id.btnScale);

		btnAlpha.setOnClickListener(this);
		btnRotate.setOnClickListener(this);
		btnTranslate.setOnClickListener(this);
		btnScale.setOnClickListener(this);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
		}

	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnAlpha:
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1)
				btnAlpha.animate().alpha(0).setDuration(400)
						.withEndAction(new Runnable() {

							@Override
							public void run() {
								btnAlpha.animate().alpha(1).setDuration(555);

							}
						});
			break;
		case R.id.btnRotate:
			// btnRotate.animate().rotation(90).setDuration(500)
			// .withEndAction(new Runnable() {
			//
			// @Override
			// public void run() {
			// btnRotate.animate().rotationBy(-180);
			//
			// }
			// });

			btnRotate.startAnimation(AnimationUtils.loadAnimation(
					MainActivity.this, R.anim.rotate));
			break;
		case R.id.btnTranslate:
			btnTranslate.animate().translationXBy(100).setDuration(500)
					.withEndAction(new Runnable() {

						@Override
						public void run() {
							btnTranslate.animate().translationXBy(-100)
									.translationY(-100)
									.withEndAction(new Runnable() {

										@Override
										public void run() {
											btnTranslate.animate()
													.translationY(100);

										}
									});

						}
					});
			break;
		case R.id.btnScale:
			btnScale.animate().scaleXBy(2).setDuration(500).scaleYBy(2)
					.withEndAction(new Runnable() {

						@Override
						public void run() {
							btnScale.animate().scaleXBy(-2).setDuration(500)
									.scaleYBy(-2);

						}
					});
			break;
		}
	}
}
