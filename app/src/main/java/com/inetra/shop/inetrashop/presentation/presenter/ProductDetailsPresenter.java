package com.inetra.shop.inetrashop.presentation.presenter;

import android.support.annotation.NonNull;

import com.fernandocejas.frodo.annotation.RxLogSubscriber;
import com.inetra.shop.inetrashop.domain.di.PerActivity;
import com.inetra.shop.inetrashop.domain.exception.DefaultErrorBundle;
import com.inetra.shop.inetrashop.domain.exception.ErrorBundle;
import com.inetra.shop.inetrashop.domain.interactor.DefaultSubscriber;
import com.inetra.shop.inetrashop.domain.interactor.UseCase;
import com.inetra.shop.inetrashop.domain.model.Product;
import com.inetra.shop.inetrashop.presentation.exception.ErrorMessageFactory;
import com.inetra.shop.inetrashop.presentation.model.ProductModel;
import com.inetra.shop.inetrashop.presentation.model.mapper.ModelDataMapper;
import com.inetra.shop.inetrashop.presentation.view.ProductDetailsView;

import javax.inject.Inject;
import javax.inject.Named;

@PerActivity
public class ProductDetailsPresenter implements Presenter {
  private ProductDetailsView viewDetailsView;
  private final UseCase getProductDetailsUseCase;
  private final ModelDataMapper productModelDataMapper;

  @Inject
  ProductDetailsPresenter(@Named("productDetails") UseCase getProductDetailsUseCase, ModelDataMapper productModelDataMapper) {
    this.getProductDetailsUseCase = getProductDetailsUseCase;
    this.productModelDataMapper = productModelDataMapper;
  }

  public void setView(@NonNull ProductDetailsView view) {
    this.viewDetailsView = view;
  }

  @Override
  public void resume() {}

  @Override
  public void pause() {}

  @Override
  public void destroy() {
    this.getProductDetailsUseCase.unsubscribe();
    this.viewDetailsView = null;
  }

  public void initialize() {
    this.loadProductDetails();
  }

  private void loadProductDetails() {
    this.hideViewRetry();
    this.showViewLoading();
    this.getProductDetails();
  }

  private void showViewLoading() {
    this.viewDetailsView.showLoading();
  }

  private void hideViewLoading() {
    this.viewDetailsView.hideLoading();
  }

  private void showViewRetry() {
    this.viewDetailsView.showRetry();
  }

  private void hideViewRetry() {
    this.viewDetailsView.hideRetry();
  }

  private void showErrorMessage(ErrorBundle errorBundle) {
    String errorMessage = ErrorMessageFactory.create(this.viewDetailsView.context(), errorBundle.getException());
    this.viewDetailsView.showError(errorMessage);
  }

  private void showProductDetailsInView(Product product) {
    final ProductModel productModel = this.productModelDataMapper.transformProduct(product);
    this.viewDetailsView.renderProduct(productModel);
  }

  private void getProductDetails() {
    this.getProductDetailsUseCase.execute(new ProductDetailsSubscriber());
  }

  @RxLogSubscriber
  private final class ProductDetailsSubscriber extends DefaultSubscriber<Product> {

    @Override
    public void onCompleted() {
      ProductDetailsPresenter.this.hideViewLoading();
    }

    @Override
    public void onError(Throwable e) {
      ProductDetailsPresenter.this.hideViewLoading();
      ProductDetailsPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
      ProductDetailsPresenter.this.showViewRetry();
    }

    @Override
    public void onNext(Product product) {
      ProductDetailsPresenter.this.showProductDetailsInView(product);
    }
  }
}
