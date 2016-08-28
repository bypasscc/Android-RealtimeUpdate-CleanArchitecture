package com.mike.domain.repository;

import com.mike.domain.BitmapItem;

import rx.Observable;

/**
 * Created by MinhNguyen on 8/27/16.
 */
public interface BitmapRepository {

    Observable<BitmapItem> loadBitmap(String url, int width, int heigth);

}
