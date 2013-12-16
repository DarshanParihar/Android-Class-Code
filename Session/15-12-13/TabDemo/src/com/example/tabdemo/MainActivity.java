package com.example.tabdemo;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements TabListener {

	private Tab yelloTab, pinkTab, redTab, blueTab, greenTab;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		redTab = getActionBar().newTab();
		redTab.setText("Red");

		yelloTab = getActionBar().newTab();
		yelloTab.setText("Yello");

		pinkTab = getActionBar().newTab();
		pinkTab.setText("Pink");

		blueTab = getActionBar().newTab();
		blueTab.setText("Blue");

		greenTab = getActionBar().newTab();
		greenTab.setText("Green");

		redTab.setTabListener(this);
		greenTab.setTabListener(this);
		blueTab.setTabListener(this);
		yelloTab.setTabListener(this);
		pinkTab.setTabListener(this);

		getActionBar().addTab(redTab);
		getActionBar().addTab(blueTab);
		getActionBar().addTab(greenTab);
		getActionBar().addTab(yelloTab);
		getActionBar().addTab(pinkTab);

		ViewPager pager;

		getActionBar().setSelectedNavigationItem(2);

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, getFragment(tab.getPosition()))
				.commit();

	}

	private Fragment getFragment(int position) {
		if (position == 0)
			return ColorFragment.newInstance(Color.RED);
		else if (position == 1)
			return ColorFragment.newInstance(Color.BLUE);
		else if (position == 2)
			return ColorFragment.newInstance(Color.GREEN);
		else if (position == 3)
			return ColorFragment.newInstance(Color.YELLOW);
		else
			return ColorFragment.newInstance(Color.MAGENTA);

	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

}
