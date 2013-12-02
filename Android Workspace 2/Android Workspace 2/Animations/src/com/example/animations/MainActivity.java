package com.example.animations;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnAlpha, btnRotate, btnTranslate, btnScale;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnAlpha = (Button) findViewById(R.id.alphaButton);
		btnRotate = (Button) findViewById(R.id.rotateButton);
		btnTranslate = (Button) findViewById(R.id.translateButton);
		btnScale = (Button) findViewById(R.id.scaleButton);

		btnAlpha.setOnClickListener(this);
		btnRotate.setOnClickListener(this);
		btnTranslate.setOnClickListener(this);
		btnScale.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.alphaButton:
			btnAlpha.startAnimation(AnimationUtils.loadAnimation(
					MainActivity.this, R.anim.alpha));
			break;
		case R.id.rotateButton:
			btnRotate.startAnimation(AnimationUtils.loadAnimation(
					MainActivity.this, R.anim.rotate));
			break;
		case R.id.translateButton:
			btnTranslate.startAnimation(AnimationUtils.loadAnimation(
					MainActivity.this, R.anim.translate));
			break;
		case R.id.scaleButton:
			btnScale.startAnimation(AnimationUtils.loadAnimation(
					MainActivity.this, R.anim.scale));
			break;
		}

	}

}
