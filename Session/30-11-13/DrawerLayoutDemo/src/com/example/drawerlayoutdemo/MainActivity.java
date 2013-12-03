package com.example.drawerlayoutdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity implements
		OnItemClickListener {
	private String[] companyList;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		companyList = new String[] { "Yahoo", "Gooogle", "Apple" };
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// Set the adapter for the list view
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, companyList));

		mDrawerList.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view,
			int position, long id) {
		CompanyFragment companyFragment = null;
		switch (position) {
		case 0:
			companyFragment = CompanyFragment
					.newInstance("http://www.yahoo.com");
			break;
		case 1:
			companyFragment = CompanyFragment
					.newInstance("http://www.google.com");
			break;
		case 2:
			companyFragment = CompanyFragment
					.newInstance("http://www.apple.com");
			break;
		}
		mDrawerLayout.closeDrawer(mDrawerList);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, companyFragment).commit();
	}
}