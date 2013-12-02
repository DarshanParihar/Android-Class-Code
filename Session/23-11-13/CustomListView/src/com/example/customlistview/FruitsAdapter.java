package com.example.customlistview;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FruitsAdapter extends BaseAdapter {
	private MainActivity activity;
	private ArrayList<Fruit> fruits;

	public FruitsAdapter(MainActivity activity, ArrayList<Fruit> fruits) {
		this.activity = activity;
		this.fruits = fruits;
	}

	@Override
	public int getCount() {
		return fruits.size();
	}

	@Override
	public Object getItem(int position) {
		return fruits.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		View row = LayoutInflater.from(activity).inflate(R.layout.row, null);
		View fruitColor = (View) row.findViewById(R.id.fruitColor);
		TextView fruitName = (TextView) row.findViewById(R.id.fruitName);

		fruitColor.setBackgroundColor(fruits.get(position).getFruitColor());
		fruitName.setText(fruits.get(position).getFruitName());

		return row;
	}

}
