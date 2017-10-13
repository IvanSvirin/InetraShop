package com.inetra.shop.inetrashop.domain.repository;

import java.util.List;

import rx.Observable;
import com.inetra.shop.inetrashop.data.entity.ProductEntity;
import com.inetra.shop.inetrashop.domain.model.BookOnCooking;
import com.inetra.shop.inetrashop.domain.model.Product;

public interface BookOnCookingRepository {

    Observable<List<BookOnCooking>> products();

    Observable<BookOnCooking> product(final String barCode);
}
