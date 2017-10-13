package com.inetra.shop.inetrashop.data.repository.factory;

import android.support.annotation.NonNull;

import com.inetra.shop.inetrashop.data.cache.BookOnCookingCache;
import com.inetra.shop.inetrashop.data.repository.datasource.BookOnCookingDataStore;
import com.inetra.shop.inetrashop.data.repository.datasource.BookOnCookingDiskDataStore;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BookOnCookingDataStoreFactory {
    private final BookOnCookingCache bookOnCookingCache;

    @Inject
    BookOnCookingDataStoreFactory(@NonNull BookOnCookingCache bookOnCookingCache) {
        this.bookOnCookingCache = bookOnCookingCache;
    }

    public BookOnCookingDataStore createList() {
        return new BookOnCookingDiskDataStore(this.bookOnCookingCache);
    }

    public BookOnCookingDataStore create(String barCode) {
        return new BookOnCookingDiskDataStore(this.bookOnCookingCache);
    }
}
