package com.example.drawerlayoutdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class CompanyFragment extends Fragment {

	public static CompanyFragment newInstance(String webAddress) {
		CompanyFragment comFragment = new CompanyFragment();
		Bundle bundle = new Bundle();
		bundle.putString("address", webAddress);
		comFragment.setArguments(bundle);
		return comFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frame, container, false);
		WebView webView = (WebView) view.findViewById(R.id.webView);
		webView.loadUrl(getArguments().getString("address"));
		return view;
	}

}
