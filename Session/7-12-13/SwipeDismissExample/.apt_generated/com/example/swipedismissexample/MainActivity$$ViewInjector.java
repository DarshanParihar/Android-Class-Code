// Generated code from Butter Knife. Do not modify!
package com.example.swipedismissexample;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.swipedismissexample.MainActivity target, Object source) {
    View view;
    view = finder.findById(source, 2131230720);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230720' for field 'friendsList' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.friendsList = (android.widget.ListView) view;
  }

  public static void reset(com.example.swipedismissexample.MainActivity target) {
    target.friendsList = null;
  }
}
