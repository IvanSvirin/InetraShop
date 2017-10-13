package com.inetra.shop.inetrashop.domain.repository;

import com.inetra.shop.inetrashop.domain.model.BookOnProgramming;

import java.util.List;

import rx.Observable;

public interface BookOnProgrammingRepository {

    Observable<List<BookOnProgramming>> products();

    Observable<BookOnProgramming> product(final String barCode);
}
