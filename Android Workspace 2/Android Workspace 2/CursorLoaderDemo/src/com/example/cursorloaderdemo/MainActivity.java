package com.example.cursorloaderdemo;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements
		LoaderCallbacks<Cursor> {

	private ListView contactList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TextView textView = new TextView(this);
		
		textView.setText("Loading Contacts!");
		setContentView(textView);
		getSupportLoaderManager().initLoader(0, null, this);
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
		return new CursorLoader(MainActivity.this,
				ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		

	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_2, cursor, new String[] {
						ContactsContract.Contacts.DISPLAY_NAME,
						ContactsContract.Contacts.HAS_PHONE_NUMBER },
				new int[] { android.R.id.text1, android.R.id.text2 }, 0);

		setContentView(R.layout.activity_main);

		contactList = (ListView) findViewById(R.id.contactList);
		contactList.setAdapter(adapter);

	}

}
