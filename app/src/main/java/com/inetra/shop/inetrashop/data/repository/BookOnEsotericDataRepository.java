package com.inetra.shop.inetrashop.data.repository;

import com.inetra.shop.inetrashop.data.entity.mapper.EntityDataMapper;
import com.inetra.shop.inetrashop.data.repository.datasource.BookOnEsotericDataStore;
import com.inetra.shop.inetrashop.data.repository.factory.BookOnEsotericDataStoreFactory;
import com.inetra.shop.inetrashop.domain.model.BookOnEsoteric;
import com.inetra.shop.inetrashop.domain.repository.BookOnEsotericRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class BookOnEsotericDataRepository implements BookOnEsotericRepository {
    private final BookOnEsotericDataStoreFactory bookOnEsotericDataStoreFactory;
    private final EntityDataMapper entityDataMapper;

    @Inject
    BookOnEsotericDataRepository(BookOnEsotericDataStoreFactory bookOnEsotericDataStoreFactory, EntityDataMapper entityDataMapper) {
        this.bookOnEsotericDataStoreFactory = bookOnEsotericDataStoreFactory;
        this.entityDataMapper = entityDataMapper;
    }

    @Override
    public Observable<List<BookOnEsoteric>> products() {
        final BookOnEsotericDataStore bookOnEsotericDataStore = this.bookOnEsotericDataStoreFactory.createList();
        return bookOnEsotericDataStore.productList().map(this.entityDataMapper::transformBookOnEsotericEntities);
    }

    @Override
    public Observable<BookOnEsoteric> product(String barCode) {
        final BookOnEsotericDataStore bookOnEsotericDataStore = this.bookOnEsotericDataStoreFactory.create(barCode);
        return bookOnEsotericDataStore.productDetails(barCode).map(this.entityDataMapper::transform);
    }
}
