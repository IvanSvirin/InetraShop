package com.inetra.shop.inetrashop.data.cache;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import com.inetra.shop.inetrashop.data.entity.BookOnEsotericEntity;
import com.inetra.shop.inetrashop.data.entity.ProductEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BookOnEsotericCacheImpl implements BookOnEsotericCache {
    private final Context context;
    private static List<BookOnEsotericEntity> books = new ArrayList<>();

    static {
        books.add(new BookOnEsotericEntity("All About Esoteric", 20.15, "651651386154658", 545, 25));
        books.add(new BookOnEsotericEntity("New Esoteric", 25.63, "5625275252582", 585, 23));
        books.add(new BookOnEsotericEntity("Myths About Esoteric", 22.36, "52452542542542", 242, 20));
    }

    @Inject
    public BookOnEsotericCacheImpl(Context context) {
        this.context = context;
    }

    @Override
    public Observable<List<BookOnEsotericEntity>> getProducts() {
        return Observable.just(books);
    }

    @Override
    public Observable<BookOnEsotericEntity> getProductByBarCode(String barCode) {
        for (BookOnEsotericEntity book : books) {
            if (book.getBarcode().equals(barCode)) return Observable.just(book);
        }
        return null;
    }
}
