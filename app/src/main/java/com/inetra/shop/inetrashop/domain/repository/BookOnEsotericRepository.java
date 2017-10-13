package com.inetra.shop.inetrashop.domain.repository;

import com.inetra.shop.inetrashop.domain.model.BookOnEsoteric;

import java.util.List;

import rx.Observable;

public interface BookOnEsotericRepository {

    Observable<List<BookOnEsoteric>> products();

    Observable<BookOnEsoteric> product(final String barCode);
}
