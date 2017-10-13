package com.inetra.shop.inetrashop.data.repository;

import com.inetra.shop.inetrashop.data.entity.mapper.EntityDataMapper;
import com.inetra.shop.inetrashop.data.repository.datasource.BookOnProgrammingDataStore;
import com.inetra.shop.inetrashop.data.repository.factory.BookOnProgrammingDataStoreFactory;
import com.inetra.shop.inetrashop.domain.model.BookOnProgramming;
import com.inetra.shop.inetrashop.domain.repository.BookOnProgrammingRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class BookOnProgrammingDataRepository implements BookOnProgrammingRepository {
    private final BookOnProgrammingDataStoreFactory bookOnProgrammingDataStoreFactory;
    private final EntityDataMapper entityDataMapper;

    @Inject
    BookOnProgrammingDataRepository(BookOnProgrammingDataStoreFactory bookOnProgrammingDataStoreFactory, EntityDataMapper entityDataMapper) {
        this.bookOnProgrammingDataStoreFactory = bookOnProgrammingDataStoreFactory;
        this.entityDataMapper = entityDataMapper;
    }

    @Override
    public Observable<List<BookOnProgramming>> products() {
        final BookOnProgrammingDataStore bookOnProgrammingDataStore = this.bookOnProgrammingDataStoreFactory.createList();
        return bookOnProgrammingDataStore.productList().map(this.entityDataMapper::transformBookOnProgrammingEntities);
    }

    @Override
    public Observable<BookOnProgramming> product(String barCode) {
        final BookOnProgrammingDataStore bookOnProgrammingDataStore = this.bookOnProgrammingDataStoreFactory.create(barCode);
        return bookOnProgrammingDataStore.productDetails(barCode).map(this.entityDataMapper::transform);
    }
}
