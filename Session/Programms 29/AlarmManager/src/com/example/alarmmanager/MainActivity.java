package com.example.alarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("First Activity");
		setContentView(R.layout.activity_main);

		AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP,
				System.currentTimeMillis() + 5000, getPendingIntent());
	}

	private PendingIntent getPendingIntent() {
		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		return PendingIntent.getActivity(MainActivity.this, 1, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);
	}
}
