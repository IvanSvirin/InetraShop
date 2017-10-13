package com.inetra.shop.inetrashop.data.repository.factory;

import android.support.annotation.NonNull;

import com.inetra.shop.inetrashop.data.cache.BookOnEsotericCache;
import com.inetra.shop.inetrashop.data.repository.datasource.BookOnEsotericDataStore;
import com.inetra.shop.inetrashop.data.repository.datasource.BookOnEsotericDiskDataStore;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BookOnEsotericDataStoreFactory {
    private final BookOnEsotericCache bookOnEsotericCache;

    @Inject
    BookOnEsotericDataStoreFactory(@NonNull BookOnEsotericCache bookOnEsotericCache) {
        this.bookOnEsotericCache = bookOnEsotericCache;
    }

    public BookOnEsotericDataStore createList() {
        return new BookOnEsotericDiskDataStore(this.bookOnEsotericCache);
    }

    public BookOnEsotericDataStore create(String barCode) {
        return new BookOnEsotericDiskDataStore(this.bookOnEsotericCache);
    }
}
