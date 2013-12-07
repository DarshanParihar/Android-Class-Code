package com.example.swipedismissexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.example.swipedismissexample.SwipeDismissListViewTouchListener.DismissCallbacks;

public class MainActivity extends Activity {
	@InjectView(R.id.friendsList)
	ListView friendsList;
	private ArrayAdapter<String> friendsAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);
		friendsAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1);

		friendsAdapter.add("Darshan");
		friendsAdapter.add("Hiren");
		friendsAdapter.add("Akshay");
		friendsAdapter.add("Vipul");

		friendsList.setAdapter(friendsAdapter);

		friendsList.setOnTouchListener(new SwipeDismissListViewTouchListener(
				friendsList, new DismissCallbacks() {

					@Override
					public void onDismiss(ListView listView,
							int[] reverseSortedPositions) {
						for (int position : reverseSortedPositions) {
							friendsAdapter.remove(friendsAdapter
									.getItem(position));
						}
					}

					@Override
					public boolean canDismiss(int position) {
						if (friendsAdapter.getItem(position).equalsIgnoreCase(
								"darshan"))
							return false;
						return true;
					}
				}));
	}

}
