package com.inetra.shop.inetrashop.data.repository.datasource;

import com.inetra.shop.inetrashop.data.cache.BookOnEsotericCache;
import com.inetra.shop.inetrashop.data.entity.BookOnEsotericEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class BookOnEsotericDiskDataStore implements BookOnEsotericDataStore {
    private final BookOnEsotericCache bookOnEsotericCache;

    public BookOnEsotericDiskDataStore(BookOnEsotericCache bookOnEsotericCache) {
        this.bookOnEsotericCache = bookOnEsotericCache;
    }

    @Override
    public Observable<List<BookOnEsotericEntity>> productList() {
        return this.bookOnEsotericCache.getProducts();
    }

    @Override
    public Observable<BookOnEsotericEntity> productDetails(String barCode) {
        return this.bookOnEsotericCache.getProductByBarCode(barCode);
    }
}
