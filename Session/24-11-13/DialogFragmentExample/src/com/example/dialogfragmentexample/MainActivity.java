package com.example.dialogfragmentexample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private Button btnShowDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnShowDialog = (Button) findViewById(R.id.btnShowDialog);
		btnShowDialog.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		new MyDialogFragment().show(getSupportFragmentManager(), "vipul");
	}
}
