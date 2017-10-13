package com.inetra.shop.inetrashop.data.cache;

import com.inetra.shop.inetrashop.data.entity.BookOnCookingEntity;
import com.inetra.shop.inetrashop.data.entity.CompactDiskEntity;

import java.util.List;

import rx.Observable;

public interface CompactDiskCache {

    Observable<List<CompactDiskEntity>> getProducts();

    Observable<CompactDiskEntity> getProductByBarCode(String barCode);
}
