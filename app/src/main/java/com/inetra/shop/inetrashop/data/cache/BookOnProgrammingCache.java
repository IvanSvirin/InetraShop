package com.inetra.shop.inetrashop.data.cache;

import com.inetra.shop.inetrashop.data.entity.BookOnProgrammingEntity;

import java.util.List;

import rx.Observable;

public interface BookOnProgrammingCache {

    Observable<List<BookOnProgrammingEntity>> getProducts();

    Observable<BookOnProgrammingEntity> getProductByBarCode(String barCode);
}
