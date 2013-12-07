// Generated code from Butter Knife. Do not modify!
package com.example.butterknifeexample;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.butterknifeexample.MainActivity target, Object source) {
    View view;
    view = finder.findById(source, 2131230720);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230720' for method 'submit' was not found. If this view is optional add '@Optional' annotation.");
    }
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.submit();
        }
      });
  }

  public static void reset(com.example.butterknifeexample.MainActivity target) {
  }
}
