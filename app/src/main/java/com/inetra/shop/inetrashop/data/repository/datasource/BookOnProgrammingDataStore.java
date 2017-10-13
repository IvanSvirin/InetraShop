package com.inetra.shop.inetrashop.data.repository.datasource;

import com.inetra.shop.inetrashop.data.entity.BookOnProgrammingEntity;

import java.util.List;

import rx.Observable;

public interface BookOnProgrammingDataStore {

  Observable<List<BookOnProgrammingEntity>> productList();

  Observable<BookOnProgrammingEntity> productDetails(final String barCode);

}
