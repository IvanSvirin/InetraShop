package com.inetra.shop.inetrashop.data.repository.datasource;

import com.inetra.shop.inetrashop.data.cache.BookOnCookingCache;
import com.inetra.shop.inetrashop.data.entity.BookOnCookingEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class BookOnCookingDiskDataStore implements BookOnCookingDataStore {
    private final BookOnCookingCache bookOnCookingCache;

    public BookOnCookingDiskDataStore(BookOnCookingCache bookOnCookingCache) {
        this.bookOnCookingCache = bookOnCookingCache;
    }

    @Override
    public Observable<List<BookOnCookingEntity>> productList() {
        return this.bookOnCookingCache.getProducts();
    }

    @Override
    public Observable<BookOnCookingEntity> productDetails(String barCode) {
        return this.bookOnCookingCache.getProductByBarCode(barCode);
    }
}
