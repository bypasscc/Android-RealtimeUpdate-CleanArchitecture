package com.mike.data.repository.datasource;

import com.mike.data.entity.DeletedEntity;
import com.mike.data.entity.FeedChangedInfoEntity;
import com.mike.data.entity.FeedEntity;
import com.mike.data.entity.WrittenEntity;
import com.mike.data.firebase.Firebase;

import rx.Observable;

/**
 * Created by MinhNguyen on 8/24/16.
 */
public class FeedDataSourceCloud implements FeedDataSource {

    Firebase fireBase;

    public FeedDataSourceCloud(Firebase fireBase) {
        this.fireBase = fireBase;
    }


    @Override
    public Observable<FeedEntity> feedEntityByIndex(int index) {
        return fireBase.feedEntityByIndex(index);
    }

    @Override
    public Observable<FeedChangedInfoEntity> registerFeedChangedEvent() {
        return fireBase.registerFeedChangedEvent();
    }

    @Override
    public Observable<WrittenEntity> writeFeed(FeedEntity entity) {
        return fireBase.writeFeed(entity);
    }


    @Override
    public Observable<DeletedEntity> deleteFeed(String key) {
        return fireBase.deleteFeed(key);
    }
}
