package com.inetra.shop.inetrashop.data.repository.factory;

import android.support.annotation.NonNull;

import com.inetra.shop.inetrashop.data.cache.CompactDiskCache;
import com.inetra.shop.inetrashop.data.repository.datasource.CompactDiskDataStore;
import com.inetra.shop.inetrashop.data.repository.datasource.CompactDiskDiskDataStore;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CompactDiskDataStoreFactory {
    private final CompactDiskCache compactDiskCache;

    @Inject
    CompactDiskDataStoreFactory(@NonNull CompactDiskCache compactDiskCache) {
        this.compactDiskCache = compactDiskCache;
    }

    public CompactDiskDataStore createList() {
        return new CompactDiskDiskDataStore(this.compactDiskCache);
    }

    public CompactDiskDataStore create(String barCode) {
        return new CompactDiskDiskDataStore(this.compactDiskCache);
    }
}
