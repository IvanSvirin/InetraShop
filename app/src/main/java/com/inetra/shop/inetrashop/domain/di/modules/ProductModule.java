package com.inetra.shop.inetrashop.domain.di.modules;

import com.inetra.shop.inetrashop.domain.di.PerActivity;
import com.inetra.shop.inetrashop.domain.executor.PostExecutionThread;
import com.inetra.shop.inetrashop.domain.executor.ThreadExecutor;
import com.inetra.shop.inetrashop.domain.interactor.GetProductDetails;
import com.inetra.shop.inetrashop.domain.interactor.GetProductList;
import com.inetra.shop.inetrashop.domain.interactor.UseCase;
import com.inetra.shop.inetrashop.domain.repository.BookOnCookingRepository;
import com.inetra.shop.inetrashop.domain.repository.BookOnEsotericRepository;
import com.inetra.shop.inetrashop.domain.repository.BookOnProgrammingRepository;
import com.inetra.shop.inetrashop.domain.repository.CompactDiskRepository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductModule {
    private String barCode = "";
    private String productModelChild = "";

    public ProductModule() {
    }

    public ProductModule(String barCode, String productModelChild) {
        this.barCode = barCode;
        this.productModelChild = productModelChild;
    }

    @Provides
    @PerActivity
    @Named("productList")
    UseCase provideGetProductListUseCase(GetProductList getProductList) {
        return getProductList;
    }

    @Provides
    @PerActivity
    @Named("productDetails")
    UseCase provideGetProductDetailsUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, BookOnCookingRepository bookOnCookingRepository,
                                            BookOnEsotericRepository bookOnEsotericRepository, BookOnProgrammingRepository bookOnProgrammingRepository, CompactDiskRepository compactDiskRepository) {
        return new GetProductDetails(barCode, productModelChild, threadExecutor, postExecutionThread, bookOnCookingRepository, bookOnEsotericRepository, bookOnProgrammingRepository, compactDiskRepository);
    }
}