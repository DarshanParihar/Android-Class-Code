package com.example.notificationdemo;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class MainActivity extends Activity {

	private NotificationManager notificationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		NotificationCompat.Builder builder = new NotificationCompat.Builder(
				this);
		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		builder.setContentTitle("My Notification")
				.setContentText("This is sample text")
				.setLargeIcon(
						BitmapFactory.decodeResource(getResources(),
								android.R.drawable.ic_dialog_alert))
				.setSmallIcon(R.drawable.ic_launcher)
				.setContentIntent(PendingIntent.getActivity(this, 0, intent, 0))
				.setAutoCancel(true).setTicker("Generating Notification");
		notificationManager.notify(1, builder.build());

	}
}
