package com.example.popupmenudemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.PopupMenu.OnMenuItemClickListener;

public class MainActivity extends Activity {

	private Button btnShowPopup;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnShowPopup = (Button) findViewById(R.id.btnShowPopup);
		btnShowPopup.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View view) {
				PopupMenu menu = new PopupMenu(MainActivity.this, view);
				menu.getMenuInflater().inflate(R.menu.main, menu.getMenu());
				menu.show();

				menu.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						if (item.getItemId() == R.id.callPhone) {
							Toast.makeText(MainActivity.this, "Call Phone",
									Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(MainActivity.this, "Send SMS",
									Toast.LENGTH_SHORT).show();
						}
						return true;
					}
				});
			}
		});
	}
}
