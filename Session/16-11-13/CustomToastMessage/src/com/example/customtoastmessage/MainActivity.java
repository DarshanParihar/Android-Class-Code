package com.example.customtoastmessage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		// Toast toast = new Toast(this);
		// toast.setView(LayoutInflater.from(this).inflate(R.layout.activity_main,
		// null));
		// toast.setDuration(Toast.LENGTH_LONG);
		// toast.setGravity(Gravity.CENTER, 0, 0);
		// toast.show();

		AlertDialog.Builder builder = new Builder(this);
		View view = LayoutInflater.from(this).inflate(R.layout.activity_main,
				null);
		builder.setView(view);
		Button button = view.findViewById(R.id.button);
		button.setOnClickListener(this);
		// builder.setPositiveButton("Dismiss", null);
		AlertDialog alertDialog = builder.create();

		alertDialog.show();
		
		alertDialog.dismiss();
	}

}
