package com.example.alarmmanagerdemo;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class SecondActivity extends Activity implements OnClickListener {

	private Button btnSwitchText;
	private TextSwitcher textSwitcher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);
		textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
		textSwitcher.setFactory(new ViewFactory() {

			
			@Override
			public View makeView() {
				TextView textView = new TextView(SecondActivity.this);
				textView.setTextSize(36);
				textView.setTextColor(Color.RED);
				return textView;
			}
		});
		textSwitcher.setInAnimation(AnimationUtils.loadAnimation(
				SecondActivity.this, android.R.anim.slide_out_right));
		textSwitcher.setOutAnimation(AnimationUtils.loadAnimation(
				SecondActivity.this, android.R.anim.slide_in_left));
		btnSwitchText = (Button) findViewById(R.id.switchText);
		btnSwitchText.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		textSwitcher.setText("" + new Random().nextInt(100));
	}
}
