package com.inetra.shop.inetrashop.data.repository;

import java.util.List;

import rx.Observable;

import com.inetra.shop.inetrashop.data.entity.mapper.EntityDataMapper;
import com.inetra.shop.inetrashop.data.repository.datasource.BookOnCookingDataStore;
import com.inetra.shop.inetrashop.data.repository.factory.BookOnCookingDataStoreFactory;
import com.inetra.shop.inetrashop.domain.model.BookOnCooking;
import com.inetra.shop.inetrashop.domain.repository.BookOnCookingRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BookOnCookingDataRepository implements BookOnCookingRepository {
    private final BookOnCookingDataStoreFactory bookOnCookingDataStoreFactory;
    private final EntityDataMapper entityDataMapper;

    @Inject
    BookOnCookingDataRepository(BookOnCookingDataStoreFactory bookOnCookingDataStoreFactory, EntityDataMapper entityDataMapper) {
        this.bookOnCookingDataStoreFactory = bookOnCookingDataStoreFactory;
        this.entityDataMapper = entityDataMapper;
    }

    @Override
    public Observable<List<BookOnCooking>> products() {
        final BookOnCookingDataStore bookOnCookingDataStore = this.bookOnCookingDataStoreFactory.createList();
        return bookOnCookingDataStore.productList().map(this.entityDataMapper::transformBookOnCookingEntities);
    }

    @Override
    public Observable<BookOnCooking> product(String barCode) {
        final BookOnCookingDataStore bookOnCookingDataStore = this.bookOnCookingDataStoreFactory.create(barCode);
        return bookOnCookingDataStore.productDetails(barCode).map(this.entityDataMapper::transform);
    }
}
