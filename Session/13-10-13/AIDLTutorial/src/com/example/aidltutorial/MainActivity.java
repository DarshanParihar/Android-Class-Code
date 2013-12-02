package com.example.aidltutorial;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
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
	private ICalc iCalc;
	private RemoteServiceConnector remoteServiceConnector;
	private Button btnBindService, btnCalculate, btnUnbindService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnBindService = (Button) findViewById(R.id.btnBindService);
		btnCalculate = (Button) findViewById(R.id.btnCalculate);
		btnUnbindService = (Button) findViewById(R.id.btnUnbindService);

		btnBindService.setOnClickListener(this);
		btnCalculate.setOnClickListener(this);
		btnUnbindService.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnBindService:
			if (remoteServiceConnector == null) {
				Toast.makeText(this, "Bind Success", Toast.LENGTH_SHORT).show();
				remoteServiceConnector = new RemoteServiceConnector();
				Intent intent = new Intent(MainActivity.this, CalcService.class);
				bindService(intent, remoteServiceConnector,
						Context.BIND_AUTO_CREATE);
			}

			break;
		case R.id.btnCalculate:
			try {
				Toast.makeText(this, "Addition is " + iCalc.add(10, 30),
						Toast.LENGTH_SHORT).show();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.btnUnbindService:
			unbindService(remoteServiceConnector);
			break;
		}

	}

	class RemoteServiceConnector implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			iCalc = ICalc.Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			iCalc = null;
		}

	}

}
