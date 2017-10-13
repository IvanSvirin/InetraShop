package com.inetra.shop.inetrashop.presentation.presenter;

import android.support.annotation.NonNull;

import com.inetra.shop.inetrashop.domain.di.PerActivity;
import com.inetra.shop.inetrashop.domain.exception.DefaultErrorBundle;
import com.inetra.shop.inetrashop.domain.exception.ErrorBundle;
import com.inetra.shop.inetrashop.domain.interactor.DefaultSubscriber;
import com.inetra.shop.inetrashop.domain.interactor.UseCase;
import com.inetra.shop.inetrashop.domain.model.Product;
import com.inetra.shop.inetrashop.presentation.exception.ErrorMessageFactory;
import com.inetra.shop.inetrashop.presentation.model.ProductListModel;
import com.inetra.shop.inetrashop.presentation.model.mapper.ModelDataMapper;
import com.inetra.shop.inetrashop.presentation.view.ProductListView;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

@PerActivity
public class ProductListPresenter implements Presenter {
    private ProductListView viewListView;
    private final UseCase getProductListUseCase;
    private final ModelDataMapper productModelDataMapper;

    @Inject
    ProductListPresenter(@Named("productList") UseCase getProductListUserCase, ModelDataMapper productModelDataMapper) {
        this.getProductListUseCase = getProductListUserCase;
        this.productModelDataMapper = productModelDataMapper;
    }

    public void setView(@NonNull ProductListView view) {
        this.viewListView = view;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void destroy() {
        this.getProductListUseCase.unsubscribe();
        this.viewListView = null;
    }

    public void initialize() {
        this.loadProductList();
    }

    private void loadProductList() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getProductList();
    }

    public void onProductClicked(ProductListModel productModel) {
        this.viewListView.viewProduct(productModel);
    }

    private void showViewLoading() {
        this.viewListView.showLoading();
    }

    private void hideViewLoading() {
        this.viewListView.hideLoading();
    }

    private void showViewRetry() {
        this.viewListView.showRetry();
    }

    private void hideViewRetry() {
        this.viewListView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.viewListView.context(),
                errorBundle.getException());
        this.viewListView.showError(errorMessage);
    }

    private void showProductsCollectionInView(Map<String, List<? extends Product>> productCollection) {
        final List<ProductListModel> productListModels = this.productModelDataMapper.transformProducts(productCollection);
        this.viewListView.renderProductList(productListModels);
    }

    private void getProductList() {
        this.getProductListUseCase.execute(new ProductListSubscriber());
    }

    private final class ProductListSubscriber extends DefaultSubscriber<Map<String, List<? extends Product>>> {

        @Override
        public void onCompleted() {
            ProductListPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            ProductListPresenter.this.hideViewLoading();
            ProductListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            ProductListPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(Map<String, List<? extends Product>> products) {
            ProductListPresenter.this.showProductsCollectionInView(products);
        }
    }
}
