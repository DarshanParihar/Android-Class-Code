package com.example.autocompletedemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {

	private AutoCompleteTextView autoCompleteTextView;
	private ArrayAdapter<String> adapter;
	private ImageView imageView;
	private ArrayList<String> items;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
		adapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_list_item_1);
		adapter.add("Add");
		adapter.add("Delete");
		adapter.add("Get");

		items = new ArrayList<String>();
		items.add("Add");
		items.add("Delete");
		items.add("Get");

		autoCompleteTextView.setAdapter(adapter);
		autoCompleteTextView.setThreshold(1);
		autoCompleteTextView.setOnItemClickListener(this);

		imageView = (ImageView) findViewById(R.id.imageView);

	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int pos,
			long id) {

		TextView textView = (TextView) view.findViewById(android.R.id.text1);
		Log.i("vipul", "Selected item is " + textView.getText().toString());
		int position = items.indexOf(textView.getText().toString());
		if (position == 0) {
			imageView.setImageResource(android.R.drawable.ic_input_add);
		} else if (position == 1) {
			imageView.setImageResource(android.R.drawable.ic_input_delete);
		} else if (position == 2) {
			imageView.setImageResource(android.R.drawable.ic_input_get);
		}

	}

}
