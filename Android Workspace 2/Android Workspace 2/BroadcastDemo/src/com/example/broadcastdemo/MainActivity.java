package com.example.broadcastdemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnStartTrackingCall, btnStopTrackingCall,
			btnStartTrackingSMS, btnStopTrackingSMS,
			btnStartTrackingCustomBroadcast, btnStoptrackingCustomBroadcast,
			btnSendCustomBroadcast;
	private IncomingCallReceiver incomingCallReceiver;
	private IncomingSMSReceiver incomingSMSReceiver;
	private CustomBroadcastReceiver customBroadcastReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnStartTrackingCall = (Button) findViewById(R.id.startTrackingCall);
		btnStopTrackingCall = (Button) findViewById(R.id.stopTrackingCall);
		btnStartTrackingSMS = (Button) findViewById(R.id.startTrackingSMS);
		btnStopTrackingSMS = (Button) findViewById(R.id.stopTrackingSMS);
		btnStartTrackingCustomBroadcast = (Button) findViewById(R.id.startTrackingCustomBroadcast);
		btnStoptrackingCustomBroadcast = (Button) findViewById(R.id.stopTrackingCustomBroadcast);
		btnSendCustomBroadcast = (Button) findViewById(R.id.sendCustomBroadcast);

		btnStartTrackingCall.setOnClickListener(this);
		btnStopTrackingCall.setOnClickListener(this);
		btnStartTrackingSMS.setOnClickListener(this);
		btnStopTrackingSMS.setOnClickListener(this);
		btnStartTrackingCustomBroadcast.setOnClickListener(this);
		btnStoptrackingCustomBroadcast.setOnClickListener(this);
		btnSendCustomBroadcast.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.startTrackingCall:
			if (incomingCallReceiver == null) {
				incomingCallReceiver = new IncomingCallReceiver();
				IntentFilter intentFilter = new IntentFilter(
						"android.intent.action.PHONE_STATE");
				// intentFilter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
				registerReceiver(incomingCallReceiver, intentFilter);
			}
			break;
		case R.id.stopTrackingCall:
			unregisterReceiver(incomingCallReceiver);
			incomingCallReceiver = null;
			break;
		case R.id.startTrackingSMS:
			if (incomingSMSReceiver == null) {
				incomingSMSReceiver = new IncomingSMSReceiver();
				IntentFilter intentFilter = new IntentFilter(
						"android.provider.Telephony.SMS_RECEIVED");
				intentFilter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
				registerReceiver(incomingSMSReceiver, intentFilter);
			}
			break;
		case R.id.stopTrackingSMS:
			unregisterReceiver(incomingSMSReceiver);
			incomingSMSReceiver = null;
			break;
		case R.id.startTrackingCustomBroadcast:
			if (customBroadcastReceiver == null) {
				customBroadcastReceiver = new CustomBroadcastReceiver();
				IntentFilter intentFilter = new IntentFilter(
						"com.sanket.android");
				registerReceiver(customBroadcastReceiver, intentFilter);
			}
			break;
		case R.id.stopTrackingCustomBroadcast:
			unregisterReceiver(customBroadcastReceiver);
			customBroadcastReceiver = null;
			break;
		case R.id.sendCustomBroadcast:
			Intent intent = new Intent();
			intent.putExtra("name", "Sanket");
			intent.setAction("com.sanket.android");
			sendBroadcast(intent);
			break;
		}
	}

	class IncomingCallReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

			if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
				String incomingPhoneNumber = intent
						.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

				Toast.makeText(context, "Got Call From " + incomingPhoneNumber,
						Toast.LENGTH_SHORT).show();

				// abortBroadcast();
			}

		}
	}

	class IncomingSMSReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			Object[] objects = (Object[]) intent.getExtras().get("pdus");

			for (int i = 0; i < objects.length; i++) {
				SmsMessage smsMessage = SmsMessage
						.createFromPdu((byte[]) objects[i]);

				Toast.makeText(
						context,
						"Got Message from "
								+ smsMessage.getDisplayOriginatingAddress(),
						Toast.LENGTH_SHORT).show();

				Toast.makeText(context,
						"SMS Message is " + smsMessage.getMessageBody(),
						Toast.LENGTH_SHORT).show();

				abortBroadcast();
			}
		}
	}

	class CustomBroadcastReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String name = intent.getStringExtra("name");
			Toast.makeText(context, "Got Broadcast from " + name,
					Toast.LENGTH_SHORT).show();
		}
	}
}
