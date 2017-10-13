package com.inetra.shop.inetrashop.data.cache;

import com.inetra.shop.inetrashop.data.entity.BookOnEsotericEntity;

import java.util.List;

import rx.Observable;

public interface BookOnEsotericCache {

    Observable<List<BookOnEsotericEntity>> getProducts();

    Observable<BookOnEsotericEntity> getProductByBarCode(String barCode);
}
