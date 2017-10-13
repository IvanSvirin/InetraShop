package com.inetra.shop.inetrashop.data.repository;

import com.inetra.shop.inetrashop.data.entity.mapper.EntityDataMapper;
import com.inetra.shop.inetrashop.data.repository.datasource.CompactDiskDataStore;
import com.inetra.shop.inetrashop.data.repository.factory.CompactDiskDataStoreFactory;
import com.inetra.shop.inetrashop.domain.model.CompactDisk;
import com.inetra.shop.inetrashop.domain.repository.CompactDiskRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class CompactDiskDataRepository implements CompactDiskRepository {
    private final CompactDiskDataStoreFactory compactDiskDataStoreFactory;
    private final EntityDataMapper entityDataMapper;

    @Inject
    CompactDiskDataRepository(CompactDiskDataStoreFactory compactDiskDataStoreFactory, EntityDataMapper entityDataMapper) {
        this.compactDiskDataStoreFactory = compactDiskDataStoreFactory;
        this.entityDataMapper = entityDataMapper;
    }

    @Override
    public Observable<List<CompactDisk>> products() {
        final CompactDiskDataStore compactDiskDataStore = this.compactDiskDataStoreFactory.createList();
        return compactDiskDataStore.productList().map(this.entityDataMapper::transformCompactDiskEntities);
    }

    @Override
    public Observable<CompactDisk> product(String barCode) {
        final CompactDiskDataStore compactDiskDataStore = this.compactDiskDataStoreFactory.create(barCode);
        return compactDiskDataStore.productDetails(barCode).map(this.entityDataMapper::transform);
    }
}
