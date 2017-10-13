package com.inetra.shop.inetrashop.data.repository.datasource;

import com.inetra.shop.inetrashop.data.entity.CompactDiskEntity;

import java.util.List;

import rx.Observable;

public interface CompactDiskDataStore {

  Observable<List<CompactDiskEntity>> productList();

  Observable<CompactDiskEntity> productDetails(final String barCode);

}
