package com.inetra.shop.inetrashop.data.repository.factory;

import android.support.annotation.NonNull;

import com.inetra.shop.inetrashop.data.cache.BookOnProgrammingCache;
import com.inetra.shop.inetrashop.data.repository.datasource.BookOnProgrammingDataStore;
import com.inetra.shop.inetrashop.data.repository.datasource.BookOnProgrammingDiskDataStore;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BookOnProgrammingDataStoreFactory {
    private final BookOnProgrammingCache bookOnProgrammingCache;

    @Inject
    BookOnProgrammingDataStoreFactory(@NonNull BookOnProgrammingCache bookOnProgrammingCache) {
        this.bookOnProgrammingCache = bookOnProgrammingCache;
    }

    public BookOnProgrammingDataStore createList() {
        return new BookOnProgrammingDiskDataStore(this.bookOnProgrammingCache);
    }

    public BookOnProgrammingDataStore create(String barCode) {
        return new BookOnProgrammingDiskDataStore(this.bookOnProgrammingCache);
    }
}
