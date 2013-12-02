package com.example.menufiledemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	private ArrayAdapter<String> itemsAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		itemsAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1);
		itemsAdapter.add("Android");
		itemsAdapter.add("iOS");
		itemsAdapter.add("Bada");

		setListAdapter(itemsAdapter);

		registerForContextMenu(getListView());
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		getMenuInflater().inflate(R.menu.main, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.delete) {
			AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
					.getMenuInfo();
			itemsAdapter.remove(itemsAdapter.getItem((int) info.id));
		} else {
			AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
					.getMenuInfo();
			String itemName = itemsAdapter.getItem((int) info.id);
			Toast.makeText(this, "Clicked on " + itemName, Toast.LENGTH_SHORT)
					.show();
		}
		return super.onContextItemSelected(item);
	}

}
