package com.example.viewpagerexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ColorFragment extends Fragment {

	public static ColorFragment newInstance(int color) {
		ColorFragment colorFragment = new ColorFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("color", color);
		colorFragment.setArguments(bundle);
		return colorFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = new View(getActivity());
		view.setBackgroundColor(getArguments().getInt("color"));
		return view;
	}

}
