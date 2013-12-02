package com.example.customlistviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView fruitsList;
	private ArrayList<Fruit> fruits;
	private FruitAdapter fruitAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		fruitsList = (ListView) findViewById(R.id.fruitsList);

		fruits = new ArrayList<Fruit>();

		fruits.add(new Fruit("Mango", Color.YELLOW, 25.5));
		fruits.add(new Fruit("Apple", Color.RED, 15.5));
		fruits.add(new Fruit("Blueberry", Color.BLUE, 50));
		fruits.add(new Fruit("Guava", Color.GREEN, 10));

		fruitAdapter = new FruitAdapter(this, fruits);
		fruitsList.setAdapter(fruitAdapter);
	}

}
