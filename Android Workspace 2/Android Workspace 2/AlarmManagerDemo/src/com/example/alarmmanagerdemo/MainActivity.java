package com.example.alarmmanagerdemo;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnStartAlarm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnStartAlarm = (Button) findViewById(R.id.startAlarm);
		btnStartAlarm.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP,
				System.currentTimeMillis() + 5000, getPendingIntent());
	}

	private PendingIntent getPendingIntent() {
		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		PendingIntent pendingIntent = PendingIntent
				.getActivity(MainActivity.this, 0, intent,
						PendingIntent.FLAG_UPDATE_CURRENT);
		return pendingIntent;
	}

}
