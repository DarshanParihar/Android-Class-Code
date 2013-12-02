package com.example.bluetoothexample;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private BluetoothAdapter bluetoothAdapter;
	private Button btnBluetooth, btnDiscoverDevices, btnMakeDiscoverable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnBluetooth = (Button) findViewById(R.id.bluetooth);
		btnBluetooth.setOnClickListener(this);

		btnDiscoverDevices = (Button) findViewById(R.id.discoverDevices);
		btnDiscoverDevices.setOnClickListener(this);

		btnMakeDiscoverable = (Button) findViewById(R.id.btnMakeVisible);
		btnMakeDiscoverable.setOnClickListener(this);

		bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

	}

	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.bluetooth) {
			if (bluetoothAdapter != null) {
				if (!bluetoothAdapter.isEnabled()) {
					Intent intent = new Intent(
							BluetoothAdapter.ACTION_REQUEST_ENABLE);
					startActivityForResult(intent, 0);
				} else {
					Log.i("vipul", "Bluetooth is Enabled!!");

					Set<BluetoothDevice> devices = bluetoothAdapter
							.getBondedDevices();

					for (BluetoothDevice device : devices) {
						Log.i("vipul",
								device.getName() + " " + device.getAddress());
					}
				}
			}
		} else if (view.getId() == R.id.discoverDevices) {

			// Create a BroadcastReceiver for ACTION_FOUND
			BroadcastReceiver mReceiver = new BroadcastReceiver() {
				public void onReceive(Context context, Intent intent) {
					String action = intent.getAction();
					// When discovery finds a device
					if (BluetoothDevice.ACTION_FOUND.equals(action)) {
						// Get the BluetoothDevice object from the Intent
						BluetoothDevice device = intent
								.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

						Log.i("vipul", "=> " + device.getName() + " : "
								+ device.getAddress());

					}
				}
			};
			// Register the BroadcastReceiver
			IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
			registerReceiver(mReceiver, filter); // Don't forget to unregister
													// during onDestroy

			bluetoothAdapter.startDiscovery();
		} else {
			Intent discoverableIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
			discoverableIntent.putExtra(
					BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
			startActivity(discoverableIntent);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				Log.i("vipul", "User turned on bluetooth");
				Log.i("vipul", bluetoothAdapter.getAddress());
			}
		}
	}
}
