package com.inetra.shop.inetrashop.presentation.view;

import com.inetra.shop.inetrashop.presentation.model.ProductModel;

public interface ProductDetailsView extends LoadDataView {

  void renderProduct(ProductModel product);
}
