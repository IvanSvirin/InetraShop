package com.inetra.shop.inetrashop.data.cache;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import com.inetra.shop.inetrashop.data.entity.BookOnProgrammingEntity;
import com.inetra.shop.inetrashop.data.entity.ProductEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BookOnProgrammingCacheImpl implements BookOnProgrammingCache {
    private final Context context;
    private static List<BookOnProgrammingEntity> books = new ArrayList<>();

    static {
        books.add(new BookOnProgrammingEntity("Java", 20.15, "651651386154658", 545, "Java"));
        books.add(new BookOnProgrammingEntity("C++", 25.12, "651651386154658", 141, "C++"));
        books.add(new BookOnProgrammingEntity("JS", 22.21, "651651386154658", 252, "JavaScript"));
    }

    @Inject
    public BookOnProgrammingCacheImpl(Context context) {
        this.context = context;
    }

    @Override
    public Observable<List<BookOnProgrammingEntity>> getProducts() {
        return Observable.just(books);
    }

    @Override
    public Observable<BookOnProgrammingEntity> getProductByBarCode(String barCode) {
        for (BookOnProgrammingEntity book : books) {
            if (book.getBarcode().equals(barCode)) return Observable.just(book);
        }
        return null;
    }
}
