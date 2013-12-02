package com.example.contactdatabasedemo;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);

		final Cursor cursor = getContentResolver().query(
				ContactsContract.Contacts.CONTENT_URI, null,
				ContactsContract.Contacts.HAS_PHONE_NUMBER + " =?",
				new String[] { String.valueOf(1) },
				ContactsContract.Contacts.DISPLAY_NAME + " ASC");

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_2, cursor, new String[] {
						ContactsContract.Contacts.DISPLAY_NAME,
						ContactsContract.Contacts.HAS_PHONE_NUMBER },
				new int[] { android.R.id.text1, android.R.id.text2 }, 0);

		setListAdapter(adapter);

		getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				/*final Cursor cursor = getContentResolver().query(
						ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
						null,
						ContactsContract.CommonDataKinds.Phone.CONTACT_ID
								+ " =?", new String[] { String.valueOf(id) },
						null);

				SimpleCursorAdapter adapter = new SimpleCursorAdapter(
						MainActivity.this,
						android.R.layout.simple_list_item_1,
						cursor,
						new String[] { ContactsContract.CommonDataKinds.Phone.DATA },
						new int[] { android.R.id.text1 }, 0);*/
				
				final Cursor cursor = getContentResolver().query(
						ContactsContract.CommonDataKinds.Email.CONTENT_URI,
						null,
						ContactsContract.CommonDataKinds.Email.CONTACT_ID
								+ " =?", new String[] { String.valueOf(id) },
						null);

				SimpleCursorAdapter adapter = new SimpleCursorAdapter(
						MainActivity.this,
						android.R.layout.simple_list_item_1,
						cursor,
						new String[] { ContactsContract.CommonDataKinds.Email.DATA },
						new int[] { android.R.id.text1 }, 0);

				setListAdapter(adapter);
			}
		});

	}
}
