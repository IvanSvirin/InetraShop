package com.inetra.shop.inetrashop.domain.di.components;

import com.inetra.shop.inetrashop.domain.di.PerActivity;
import com.inetra.shop.inetrashop.domain.di.modules.ActivityModule;
import com.inetra.shop.inetrashop.domain.di.modules.ProductModule;
import com.inetra.shop.inetrashop.presentation.view.fragment.ProductDetailsFragment;
import com.inetra.shop.inetrashop.presentation.view.fragment.ProductListFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, ProductModule.class})
public interface ProductComponent extends ActivityComponent {
  void inject(ProductListFragment productListFragment);
  void inject(ProductDetailsFragment productDetailsFragment);
}
