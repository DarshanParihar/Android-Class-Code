package com.example.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class CalculatorService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return new ICalc.Stub() {

			@Override
			public int add(int num1, int num2) throws RemoteException {
				return num1 + num2;
			}
		};
	}
}
