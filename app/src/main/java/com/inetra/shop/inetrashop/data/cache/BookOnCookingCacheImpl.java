package com.inetra.shop.inetrashop.data.cache;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import com.inetra.shop.inetrashop.data.entity.BookOnCookingEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BookOnCookingCacheImpl implements BookOnCookingCache {
    private final Context context;
    private static List<BookOnCookingEntity> books = new ArrayList<>();
    static {
        books.add(new BookOnCookingEntity("Different Dishes", 20.15, "651651386154658", 545, "salt"));
        books.add(new BookOnCookingEntity("Meat Dishes", 23.15, "757474778578578", 414, "meat"));
        books.add(new BookOnCookingEntity("Vegetable Dishes", 65.23, "7525274255424", 252, "cucumber"));
    }

    @Inject
    public BookOnCookingCacheImpl(Context context) {
        this.context = context;
    }

    @Override
    public Observable<List<BookOnCookingEntity>> getProducts() {
        return Observable.just(books);
    }

    @Override
    public Observable<BookOnCookingEntity> getProductByBarCode(String barCode) {
        for (BookOnCookingEntity book : books) {
            if (book.getBarcode().equals(barCode)) return Observable.just(book);
        }
        return null;
    }
}
