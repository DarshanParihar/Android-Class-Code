package com.example.customlistview;

import java.util.ArrayList;

import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ArrayList<Fruit> fruits = new ArrayList<Fruit>();

		fruits.add(new Fruit("Apple", Color.RED));
		fruits.add(new Fruit("Grapes", Color.BLACK));
		fruits.add(new Fruit("Guava", Color.GREEN));
		fruits.add(new Fruit("Banana", Color.YELLOW));

		getListView().setAdapter(new FruitsAdapter(this, fruits));
	}
}
