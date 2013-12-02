package com.example.parecelabledemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnSwitchActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnSwitchActivity = (Button) findViewById(R.id.startSecond);
		btnSwitchActivity.setOnClickListener(this);
		btnSwitchActivity.setText(getResources().getString(
				R.string.button_title));

		String[] colors = getResources().getStringArray(R.array.colors);

		for (String color : colors) {
			Log.i("vipul", color);
		}

		for (int i = 0; i < colors.length; i++) {
			Log.i("vipul", colors[i]);
		}

	}

	@Override
	public void onClick(View v) {

		Person person = new Person();
		person.setName("Vipul");
		person.setAge(27);
		person.setLocation("Thane");

		Bundle bundle = new Bundle();
		bundle.putParcelable("person", person);

		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		intent.putExtras(bundle);
		startActivity(intent);

	}

}
