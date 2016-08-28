package com.mike.feed.dependency.injection;

import android.content.Context;

import com.mike.feed.ui.MainFragment;
import com.mike.feed.ui.NewFeedFragment;

import javax.inject.Singleton;

import dagger.Component;



@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {
    Context context();

    MainFragment.MainScreenComponent plus(MainFragment.MainScreenModule module);

    NewFeedFragment.NewFeedComponent plus(NewFeedFragment.NewFeedModule module);
}
