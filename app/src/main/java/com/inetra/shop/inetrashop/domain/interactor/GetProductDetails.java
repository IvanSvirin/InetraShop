package com.inetra.shop.inetrashop.domain.interactor;

import com.inetra.shop.inetrashop.domain.executor.PostExecutionThread;
import com.inetra.shop.inetrashop.domain.executor.ThreadExecutor;
import com.inetra.shop.inetrashop.domain.repository.BookOnCookingRepository;
import com.inetra.shop.inetrashop.domain.repository.BookOnEsotericRepository;
import com.inetra.shop.inetrashop.domain.repository.BookOnProgrammingRepository;
import com.inetra.shop.inetrashop.domain.repository.CompactDiskRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetProductDetails extends UseCase {
    private final String barCode;
    private final String productModelChild;

    private final BookOnCookingRepository bookOnCookingRepository;
    private final BookOnEsotericRepository bookOnEsotericRepository;
    private final BookOnProgrammingRepository bookOnProgrammingRepository;
    private final CompactDiskRepository compactDiskRepository;

    @Inject
    public GetProductDetails(String barCode, String productModelChild, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, BookOnCookingRepository bookOnCookingRepository,
                             BookOnEsotericRepository bookOnEsotericRepository, BookOnProgrammingRepository bookOnProgrammingRepository, CompactDiskRepository compactDiskRepository) {
        super(threadExecutor, postExecutionThread);
        this.barCode = barCode;
        this.productModelChild = productModelChild;
        this.bookOnCookingRepository = bookOnCookingRepository;
        this.bookOnEsotericRepository = bookOnEsotericRepository;
        this.bookOnProgrammingRepository = bookOnProgrammingRepository;
        this.compactDiskRepository = compactDiskRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        switch (productModelChild) {
            case "BookOnCookingModel":
                return this.bookOnCookingRepository.product(this.barCode);
            case "BookOnEsotericModel":
                return this.bookOnEsotericRepository.product(this.barCode);
            case "BookOnProgrammingModel":
                return this.bookOnProgrammingRepository.product(this.barCode);
            case "CompactDiskModel":
                return this.compactDiskRepository.product(this.barCode);
            default:
                return this.compactDiskRepository.product(this.barCode);
        }
    }
}
