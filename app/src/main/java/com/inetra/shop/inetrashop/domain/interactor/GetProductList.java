package com.inetra.shop.inetrashop.domain.interactor;

import com.inetra.shop.inetrashop.domain.executor.PostExecutionThread;
import com.inetra.shop.inetrashop.domain.executor.ThreadExecutor;
import com.inetra.shop.inetrashop.domain.model.Product;
import com.inetra.shop.inetrashop.domain.repository.BookOnCookingRepository;
import com.inetra.shop.inetrashop.domain.repository.BookOnEsotericRepository;
import com.inetra.shop.inetrashop.domain.repository.BookOnProgrammingRepository;
import com.inetra.shop.inetrashop.domain.repository.CompactDiskRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

public class GetProductList extends UseCase {
    private final Map<String, List<? extends Product>> products = new HashMap<>();
    private final BookOnCookingRepository bookOnCookingRepository;
    private final BookOnEsotericRepository bookOnEsotericRepository;
    private final BookOnProgrammingRepository bookOnProgrammingRepository;
    private final CompactDiskRepository compactDiskRepository;

    @Inject
    GetProductList(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, BookOnCookingRepository bookOnCookingRepository,
                   BookOnEsotericRepository bookOnEsotericRepository, BookOnProgrammingRepository bookOnProgrammingRepository, CompactDiskRepository compactDiskRepository) {
        super(threadExecutor, postExecutionThread);
        this.bookOnCookingRepository = bookOnCookingRepository;
        this.bookOnEsotericRepository = bookOnEsotericRepository;
        this.bookOnProgrammingRepository = bookOnProgrammingRepository;
        this.compactDiskRepository = compactDiskRepository;
    }

    @Override
    public Observable buildUseCaseObservable() {
        this.bookOnCookingRepository.products().subscribe(bookOnCookingList -> {
            products.put("BookOnCooking", bookOnCookingList);
        });
        this.bookOnEsotericRepository.products().subscribe(bookOnEsotericList -> {
            products.put("BookOnEsoteric", bookOnEsotericList);
        });
        this.bookOnProgrammingRepository.products().subscribe(bookOnProgrammingList -> {
            products.put("BookOnProgramming", bookOnProgrammingList);
        });
        this.compactDiskRepository.products().subscribe(compactDiskList -> {
            products.put("CompactDisk", compactDiskList);
        });
        return Observable.just(products);
    }
}
