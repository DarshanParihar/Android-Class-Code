package com.example.alertdialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnShowAlertDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnShowAlertDialog = (Button) findViewById(R.id.showAlertDialog);
		btnShowAlertDialog.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("Please Confirm");
		builder.setMessage("Are you sure want to exit?");
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "Clicked on Yes Button",
						Toast.LENGTH_SHORT).show();
				finish();

			}
		});
		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "Clicked on No Button",
						Toast.LENGTH_SHORT).show();

			}
		});
		builder.show();

	}

}
