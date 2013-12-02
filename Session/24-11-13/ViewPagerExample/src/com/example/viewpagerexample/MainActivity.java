package com.example.viewpagerexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewPager = (ViewPager) findViewById(R.id.viewPager);

		viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));

	}

	class MyPageAdapter extends FragmentPagerAdapter {

		public MyPageAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			if (position == 0)
				return ColorFragment.newInstance(Color.RED);
			else if (position == 1)
				return ColorFragment.newInstance(Color.BLUE);
			else if (position == 2)
				return ColorFragment.newInstance(Color.CYAN);
			else
				return ColorFragment.newInstance(Color.GREEN);
		}

		@Override
		public int getCount() {
			return 4;
		}

	}

}
