package com.example.customlistview;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FruitAdapter extends BaseAdapter {
	private MainActivity mainActivity;
	private ArrayList<Fruit> fruits;

	public FruitAdapter(MainActivity mainActivity, ArrayList<Fruit> fruits) {
		this.mainActivity = mainActivity;
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
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		View rowView = LayoutInflater.from(mainActivity).inflate(R.layout.row,
				null);

		View fruitColor = rowView.findViewById(R.id.fruitColor);
		TextView fruitName = (TextView) rowView.findViewById(R.id.fruitName);
		TextView fruitPrice = (TextView) rowView.findViewById(R.id.fruitPrice);

		fruitColor.setBackgroundColor(fruits.get(position).getFruitColor());
		fruitName.setText(fruits.get(position).getFruitName());
		fruitPrice.setText("" + fruits.get(position).getFruitPrice());

		return rowView;
	}

}
