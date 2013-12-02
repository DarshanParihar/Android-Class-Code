package com.example.checkboxradiobuttondemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnCheckedChangeListener,
		RadioGroup.OnCheckedChangeListener {

	private CheckBox chkCricket, chkHockey, chkFootball;
	private RadioGroup genderGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		chkCricket = (CheckBox) findViewById(R.id.cricket);
		chkHockey = (CheckBox) findViewById(R.id.hockey);
		chkFootball = (CheckBox) findViewById(R.id.football);

		chkCricket.setOnCheckedChangeListener(MainActivity.this);
		chkHockey.setOnCheckedChangeListener(MainActivity.this);
		chkFootball.setOnCheckedChangeListener(MainActivity.this);

		genderGroup = (RadioGroup) findViewById(R.id.genderGroup);
		genderGroup.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		CheckBox checkBox = (CheckBox) buttonView;
		String message = "";
		switch (checkBox.getId()) {
		case R.id.cricket:
			message = "Cricket ";
			break;
		case R.id.hockey:
			message = "Hockey ";
			break;
		case R.id.football:
			message = "Football ";
			break;
		}

		if (isChecked) {
			message += "is Checked";
		} else {
			message += "is Unchecked";
		}

		Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.male:
			Toast.makeText(MainActivity.this, "Checked Male",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.female:
			Toast.makeText(MainActivity.this, "Checked Female",
					Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
