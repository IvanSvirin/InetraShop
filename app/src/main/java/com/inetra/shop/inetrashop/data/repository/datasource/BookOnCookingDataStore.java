package com.inetra.shop.inetrashop.data.repository.datasource;

import com.inetra.shop.inetrashop.data.entity.BookOnCookingEntity;
import com.inetra.shop.inetrashop.data.entity.ProductEntity;

import java.util.List;

import rx.Observable;

public interface BookOnCookingDataStore {

  Observable<List<BookOnCookingEntity>> productList();

  Observable<BookOnCookingEntity> productDetails(final String barCode);

}
