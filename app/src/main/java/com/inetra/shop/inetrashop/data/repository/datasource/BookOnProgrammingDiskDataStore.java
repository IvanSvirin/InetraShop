package com.inetra.shop.inetrashop.data.repository.datasource;

import com.inetra.shop.inetrashop.data.cache.BookOnProgrammingCache;
import com.inetra.shop.inetrashop.data.entity.BookOnProgrammingEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class BookOnProgrammingDiskDataStore implements BookOnProgrammingDataStore {
    private final BookOnProgrammingCache bookOnProgrammingCache;

    public BookOnProgrammingDiskDataStore(BookOnProgrammingCache bookOnProgrammingCache) {
        this.bookOnProgrammingCache = bookOnProgrammingCache;
    }

    @Override
    public Observable<List<BookOnProgrammingEntity>> productList() {
        return this.bookOnProgrammingCache.getProducts();
    }

    @Override
    public Observable<BookOnProgrammingEntity> productDetails(String barCode) {
        return this.bookOnProgrammingCache.getProductByBarCode(barCode);
    }
}
