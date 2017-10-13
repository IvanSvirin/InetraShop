package com.inetra.shop.inetrashop.domain.repository;

import com.inetra.shop.inetrashop.domain.model.CompactDisk;

import java.util.List;

import rx.Observable;

public interface CompactDiskRepository {

    Observable<List<CompactDisk>> products();

    Observable<CompactDisk> product(final String barCode);
}
