package com.example.optioncontextfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private File file;
	private ListView contactList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		file = new File(Environment.getExternalStorageDirectory(), "vipul.txt");

		contactList = (ListView) findViewById(R.id.contactList);
		registerForContextMenu(contactList);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.option_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.createFile:

			try {
				if (!file.exists()) {
					if (file.createNewFile()) {
						Toast.makeText(this, "File created!!",
								Toast.LENGTH_SHORT).show();
					}
				}

				FileOutputStream fileOutputStream = new FileOutputStream(file,
						true);
				fileOutputStream.write("This is sample text".getBytes());
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		case R.id.viewFile:
			try {
				byte[] bytes = new byte[(int) file.length()];
				FileInputStream fileInputStream = new FileInputStream(file);
				fileInputStream.read(bytes);
				fileInputStream.close();
				Toast.makeText(this, "File contents are " + new String(bytes),
						Toast.LENGTH_SHORT).show();
			} catch (FileNotFoundException e) {
				Toast.makeText(this, "Could not read the file!",
						Toast.LENGTH_SHORT).show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.deleteFile:
			if (file.exists()) {
				if (file.delete()) {
					Toast.makeText(this, "File deleted", Toast.LENGTH_SHORT)
							.show();
				}
			}
			break;
		}
		return true;

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		getMenuInflater().inflate(R.menu.context_menu, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) item
				.getMenuInfo();
		long clickIndex = adapterContextMenuInfo.id;
		switch (item.getItemId()) {
		case R.id.view:
			Toast.makeText(
					this,
					"Item is "
							+ contactList.getAdapter()
									.getItem((int) clickIndex),
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.position:
			Toast.makeText(this, "Position is " + clickIndex,
					Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onContextItemSelected(item);
	}
}
