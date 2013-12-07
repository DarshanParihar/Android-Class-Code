package com.example.butterknifeexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

	@OnClick(R.id.btnClick)
	void submit() {
		Toast.makeText(this, "Clicked Me", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);

	}

}
