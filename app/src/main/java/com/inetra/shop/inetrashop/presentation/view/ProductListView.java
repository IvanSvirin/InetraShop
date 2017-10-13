package com.inetra.shop.inetrashop.presentation.view;

import com.inetra.shop.inetrashop.presentation.model.ProductListModel;
import com.inetra.shop.inetrashop.presentation.model.ProductModel;

import java.util.Collection;

public interface ProductListView extends LoadDataView {

    void renderProductList(Collection<ProductListModel> productModelCollection);

    void viewProduct(ProductListModel productModel);
}
