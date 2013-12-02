package com.example.customlistview;

import java.util.ArrayList;

import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity implements OnItemClickListener {

	private FruitAdapter fruitAdapter;
	private ArrayList<Fruit> fruits;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		fruits = new ArrayList<Fruit>();
		fruits.add(new Fruit("Mango", Color.YELLOW, 20.5));
		fruits.add(new Fruit("Apple", Color.RED, 40.5));
		fruits.add(new Fruit("Guava", Color.GREEN, 10.5));
		fruits.add(new Fruit("Blueberry", Color.BLUE, 30));

		fruitAdapter = new FruitAdapter(this, fruits);
		getListView().setAdapter(fruitAdapter);
		getListView().setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view,
			int position, long id) {
		// View rowView = view;

		View toastView = LayoutInflater.from(this).inflate(R.layout.row, null);
		toastView.setBackgroundResource(R.drawable.background);

		View fruitColor = toastView.findViewById(R.id.fruitColor);
		TextView fruitName = (TextView) toastView.findViewById(R.id.fruitName);
		TextView fruitPrice = (TextView) toastView
				.findViewById(R.id.fruitPrice);

		fruitColor.setBackgroundColor(fruits.get(position).getFruitColor());
		fruitName.setText(fruits.get(position).getFruitName());
		fruitPrice.setText(fruits.get(position).getFruitPrice() + "");

		Toast toast = new Toast(MainActivity.this);
		toast.setView(toastView);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.show();

	}
}
