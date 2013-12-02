package com.example.androidfilesystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button createFile, writeFile, readFile, deleteFile;
	private File file;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		createFile = (Button) findViewById(R.id.createFile);
		writeFile = (Button) findViewById(R.id.writeFile);
		readFile = (Button) findViewById(R.id.readFile);
		deleteFile = (Button) findViewById(R.id.deleteFile);

		createFile.setOnClickListener(this);
		writeFile.setOnClickListener(this);
		readFile.setOnClickListener(this);
		deleteFile.setOnClickListener(this);

		file = new File(Environment.getExternalStorageDirectory(), "Sanket.txt");

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.createFile:
			try {
				if (!file.exists()) {
					if (file.createNewFile()) {
						showMessage("File created succefully");
					}
				} else {
					showMessage("File already created!");
				}
			} catch (Exception exception) {

			}
			break;
		case R.id.writeFile:
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write("This is sample text".getBytes());
				fileOutputStream.close();
			} catch (Exception exception) {

			}
			break;
		case R.id.readFile:
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(fileInputStream));
				String temp;
				StringBuilder builder = new StringBuilder();
				while ((temp = bufferedReader.readLine()) != null) {
					builder.append(temp + System.getProperty("line.separator"));
				}
				showMessage("Data is \n" + builder.toString());
				bufferedReader.close();
				fileInputStream.close();
			} catch (Exception exception) {

			}
			break;
		case R.id.deleteFile:
			if (file.exists()) {
				if (file.delete()) {
					showMessage("File deleted successfully");
				}
			} else {
				showMessage("Could not locate file on below path\n"
						+ file.getAbsolutePath());
			}
			break;
		}
	}

	private void showMessage(String message) {

		Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
	}

}
