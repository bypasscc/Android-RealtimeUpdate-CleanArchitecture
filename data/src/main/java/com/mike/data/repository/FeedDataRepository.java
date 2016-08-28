package com.mike.data.repository;

import com.mike.data.entity.DeletedEntity;
import com.mike.data.entity.FeedChangedInfoEntity;
import com.mike.data.entity.FeedEntity;
import com.mike.data.entity.WrittenEntity;
import com.mike.data.entity.mapper.FeedEntityDataMapper;
import com.mike.data.repository.datasource.FeedDataSourceFactory;
import com.mike.domain.Deleted;
import com.mike.domain.Feed;
import com.mike.domain.FeedChangedInfo;
import com.mike.domain.Written;
import com.mike.domain.repository.FeedRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by MinhNguyen on 8/24/16.
 */

@Singleton
public class FeedDataRepository implements FeedRepository {


    private final FeedDataSourceFactory factory;
    private final FeedEntityDataMapper mapper;

    @Inject
    public FeedDataRepository(FeedDataSourceFactory factory, FeedEntityDataMapper mapper) {
        this.factory = factory;
        this.mapper = mapper;
    }


    @Override
    public Observable<Feed> getFeed(int index) {
        return factory.createCloudDataSource().feedEntityByIndex(index)
                .map(new Func1<FeedEntity, Feed>() {
                    @Override
                    public Feed call(FeedEntity feedEntity) {
                        return mapper.transform(feedEntity);
                    }
                });
    }


    @Override
    public Observable<FeedChangedInfo> registerFeedChangedEvent() {
        return factory.createCloudDataSource().registerFeedChangedEvent().map(new Func1<FeedChangedInfoEntity, FeedChangedInfo>() {
            @Override
            public FeedChangedInfo call(FeedChangedInfoEntity entity) {
                return mapper.transform(entity);
            }
        });
    }

    @Override
    public Observable<Written> writeFeed(Feed feed) {
        return factory.createCloudDataSource().writeFeed(mapper.transform(feed)).map(new Func1<WrittenEntity, Written>() {
            @Override
            public Written call(WrittenEntity writtenEntity) {
                return mapper.transform(writtenEntity);
            }
        });
    }

    @Override
    public Observable<Deleted> deleteFeed(String key) {
        return factory.createCloudDataSource().deleteFeed(key).map(new Func1<DeletedEntity, Deleted>() {
            @Override
            public Deleted call(DeletedEntity deletedEntity) {
                return mapper.transform(deletedEntity);
            }
        });
    }
}
