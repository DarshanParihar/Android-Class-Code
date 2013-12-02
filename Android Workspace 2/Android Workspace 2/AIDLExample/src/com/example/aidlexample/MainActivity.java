package com.example.aidlexample;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button bindService, calculate, unBindService;
	private ServiceConnector serviceConnector;
	private ICalc iCalc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bindService = (Button) findViewById(R.id.bindService);
		calculate = (Button) findViewById(R.id.calculate);
		unBindService = (Button) findViewById(R.id.unbindService);

		bindService.setOnClickListener(this);
		calculate.setOnClickListener(this);
		unBindService.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bindService:
			serviceConnector = new ServiceConnector();
			bindService(new Intent(this, ICalcService.class), serviceConnector,
					BIND_AUTO_CREATE);
			break;
		case R.id.calculate:
			try {
				Toast.makeText(this, "Addition is " + iCalc.add(10, 20),
						Toast.LENGTH_SHORT).show();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case R.id.unbindService:
			unbindService(serviceConnector);
			iCalc = null;
			break;
		}
	}

	class ServiceConnector implements ServiceConnection {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Toast.makeText(MainActivity.this, "Service Connected!!",
					Toast.LENGTH_SHORT).show();
			iCalc = ICalc.Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			iCalc = null;
		}
	}
}
