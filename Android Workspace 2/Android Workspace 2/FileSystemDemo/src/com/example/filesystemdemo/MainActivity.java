package com.example.filesystemdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	private File file;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		file = new File(Environment.getExternalStorageDirectory(), "Vipul.txt");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.create:
			if (!file.exists()) {
				try {
					if (file.createNewFile()) {
						Toast.makeText(this, "File created successfully!",
								Toast.LENGTH_SHORT).show();
						FileOutputStream fileOutputStream = new FileOutputStream(
								file);
						fileOutputStream
								.write("This is sample text".getBytes());
						fileOutputStream.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
		case R.id.view:
			if (file.exists()) {
				try {
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(new FileInputStream(file)));
					String contents = bufferedReader.readLine();
					bufferedReader.close();
					Toast.makeText(this, "file contents are " + contents,
							Toast.LENGTH_SHORT).show();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				Toast.makeText(this, "File not found!!", Toast.LENGTH_SHORT)
						.show();
			}
			break;
		case R.id.delete:
			if (file.exists()) {
				if (file.delete()) {
					Toast.makeText(this, "File deleted successfully!",
							Toast.LENGTH_SHORT).show();
				}
			}
			break;

		}
		return true;
	}
}
