package com.example.aidldemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private ICalc iCalc;
	private MyServiceConnector myServiceConnector;
	private Button btnBindService, btnCalculate, btnUnbindService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnBindService = (Button) findViewById(R.id.bindService);
		btnCalculate = (Button) findViewById(R.id.calculate);
		btnUnbindService = (Button) findViewById(R.id.unbindService);

		btnBindService.setOnClickListener(this);
		btnUnbindService.setOnClickListener(this);
		btnCalculate.setOnClickListener(this);

	}

	class MyServiceConnector implements ServiceConnection {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Toast.makeText(MainActivity.this, "Service Connected",
					Toast.LENGTH_SHORT).show();
			iCalc = ICalc.Stub.asInterface(service);

		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.i("vipul", "onServiceDisconnected");
			Toast.makeText(MainActivity.this, "Service Dissconnected",
					Toast.LENGTH_SHORT).show();
			iCalc = null;

		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bindService:
			Intent intent = new Intent(MainActivity.this,
					CalculatorService.class);
			myServiceConnector = new MyServiceConnector();
			bindService(intent, myServiceConnector, Context.BIND_AUTO_CREATE);
			break;
		case R.id.calculate:
			try {
				Toast.makeText(MainActivity.this,
						"Answer is " + iCalc.add(10, 20), Toast.LENGTH_SHORT)
						.show();
			} catch (Exception e) {
				Toast.makeText(MainActivity.this, e.getMessage(),
						Toast.LENGTH_SHORT).show();
			}	
			break;
		case R.id.unbindService:

			unbindService(myServiceConnector);
			myServiceConnector = null;
			iCalc = null;
			break;
		}

	}

}
