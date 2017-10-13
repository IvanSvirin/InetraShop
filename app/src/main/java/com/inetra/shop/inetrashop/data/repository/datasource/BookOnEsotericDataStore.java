package com.inetra.shop.inetrashop.data.repository.datasource;

import com.inetra.shop.inetrashop.data.entity.BookOnEsotericEntity;

import java.util.List;

import rx.Observable;

public interface BookOnEsotericDataStore {

  Observable<List<BookOnEsotericEntity>> productList();

  Observable<BookOnEsotericEntity> productDetails(final String barCode);

}
