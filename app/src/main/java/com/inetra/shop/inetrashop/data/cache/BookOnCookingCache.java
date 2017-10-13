package com.inetra.shop.inetrashop.data.cache;

import com.inetra.shop.inetrashop.data.entity.BookOnCookingEntity;

import java.util.List;

import rx.Observable;

public interface BookOnCookingCache {

    Observable<List<BookOnCookingEntity>> getProducts();

    Observable<BookOnCookingEntity> getProductByBarCode(String barCode);
}
