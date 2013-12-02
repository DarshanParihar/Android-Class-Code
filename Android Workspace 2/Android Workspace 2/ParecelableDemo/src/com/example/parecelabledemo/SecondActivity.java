package com.example.parecelabledemo;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TimerTask task = new TimerTask() {

			@Override
			public void run() {

				Bundle bundle = getIntent().getExtras();
				Person person = bundle.getParcelable("person");
				Log.i("vipul", person.getName());
				Log.i("vipul", "" + person.getAge());
				Log.i("vipul", person.getLocation());
			}
		};

		new Timer().schedule(task, 5000);
	}
}
