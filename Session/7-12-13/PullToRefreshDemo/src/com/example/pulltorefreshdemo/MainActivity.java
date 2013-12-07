package com.example.pulltorefreshdemo;

import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements OnRefreshListener {

	private PullToRefreshLayout pullToRefreshLayout;
	private ListView friendsList;
	private ArrayAdapter<String> friendsAdapter;
	private String[] newFriends = { "Ashok", "Kalpesh", "Vinay", "Vikas",
			"Jayesh" };
	private int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		friendsAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1);

		friendsAdapter.add("Sanket");
		friendsAdapter.add("Darshan");
		friendsAdapter.add("Hiren");

		pullToRefreshLayout = (PullToRefreshLayout) findViewById(R.id.pullLayout);
		friendsList = (ListView) findViewById(R.id.friendsList);

		ActionBarPullToRefresh.from(this).allChildrenArePullable()
				.listener(this).setup(pullToRefreshLayout);

		friendsList.setAdapter(friendsAdapter);
	}

	@Override
	public void onRefreshStarted(View view) {

		new Thread() {
			public void run() {

				for (; i < 5;) {
					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							friendsAdapter.add(newFriends[i]);
						}
					});
					SystemClock.sleep(1000);
					i++;
				}

				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						pullToRefreshLayout.setRefreshComplete();
						i = 0;
					}
				});
			};
		}.start();

	}
}
