package com.example.menudemos;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	private ArrayAdapter<String> itemsAdapter;
	private String[] countries;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		countries = getResources().getStringArray(R.array.countries);
		itemsAdapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_list_item_1, countries);
		setListAdapter(itemsAdapter);
		registerForContextMenu(getListView());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		getMenuInflater().inflate(R.menu.menu, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();
		Toast.makeText(
				MainActivity.this,
				"Clicked " + item.getTitle() + " for "
						+ countries[(int) info.id], Toast.LENGTH_SHORT).show();

		return super.onContextItemSelected(item);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(MainActivity.this, "Selected " + item.getTitle(),
				Toast.LENGTH_SHORT).show();
		return super.onOptionsItemSelected(item);
	}

}
