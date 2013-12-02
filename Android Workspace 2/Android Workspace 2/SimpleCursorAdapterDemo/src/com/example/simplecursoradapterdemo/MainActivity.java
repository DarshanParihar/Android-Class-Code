package com.example.simplecursoradapterdemo;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ListActivity implements OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Cursor cursor = getContentResolver().query(
				ContactsContract.Contacts.CONTENT_URI, null,
				ContactsContract.Contacts.HAS_PHONE_NUMBER + "=?",
				new String[] { "1" }, null);

		/*
		 * Cursor cursor = getContentResolver().query(
		 * ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, null, null,
		 * null);
		 */

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_1, cursor,
				new String[] { ContactsContract.Contacts.DISPLAY_NAME },
				new int[] { android.R.id.text1 }, 0);
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int pos,
			long id) {
		Log.i("vipul", "Id is " + id);

		Cursor cursor = getContentResolver().query(
				ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
				ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?",
				new String[] { String.valueOf(id) }, null);
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_1, cursor,
				new String[] { ContactsContract.CommonDataKinds.Phone.DATA },
				new int[] { android.R.id.text1 }, 0);
		setListAdapter(adapter);
	}

}
