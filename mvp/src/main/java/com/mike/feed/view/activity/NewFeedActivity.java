package com.mike.feed.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mike.feed.view.base.BaseHostActivity;
import com.mike.feed.view.fragment.NewFeedFragment;

/**
 * Created by MinhNguyen on 8/26/16.
 */
public class NewFeedActivity extends BaseHostActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            NewFeedFragment fragment = NewFeedFragment.createInstance();
            replace(fragment, NewFeedFragment.class.getSimpleName());
        }
    }


}
