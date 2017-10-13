package com.inetra.shop.inetrashop.data.repository.datasource;

import com.inetra.shop.inetrashop.data.cache.CompactDiskCache;
import com.inetra.shop.inetrashop.data.entity.CompactDiskEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class CompactDiskDiskDataStore implements CompactDiskDataStore {
    private final CompactDiskCache compactDiskCache;

    public CompactDiskDiskDataStore(CompactDiskCache compactDiskCache) {
        this.compactDiskCache = compactDiskCache;
    }

    @Override
    public Observable<List<CompactDiskEntity>> productList() {
        return this.compactDiskCache.getProducts();
    }

    @Override
    public Observable<CompactDiskEntity> productDetails(String barCode) {
        return this.compactDiskCache.getProductByBarCode(barCode);
    }
}

