package com.inetra.shop.inetrashop.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.inetra.shop.inetrashop.R;
import com.inetra.shop.inetrashop.domain.di.HasComponent;
import com.inetra.shop.inetrashop.domain.di.components.DaggerProductComponent;
import com.inetra.shop.inetrashop.domain.di.components.ProductComponent;
import com.inetra.shop.inetrashop.presentation.model.ProductListModel;
import com.inetra.shop.inetrashop.presentation.view.fragment.ProductListFragment;

public class ProductListActivity extends BaseActivity implements HasComponent<ProductComponent>, ProductListFragment.ProductListListener {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, ProductListActivity.class);
    }

    private ProductComponent productComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);

        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new ProductListFragment());
        }
        setTitle("Products");
    }

    private void initializeInjector() {
        this.productComponent = DaggerProductComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public ProductComponent getComponent() {
        return productComponent;
    }

    public void onProductClicked(ProductListModel productListModel) {
        String productModelChild = "";
        switch (productListModel.getCategory()) {
            case "Books":
                switch (productListModel.getSubCategory()) {
                    case "Cooking":
                        productModelChild = "BookOnCookingModel";
                        break;
                    case "Esoteric":
                        productModelChild = "BookOnEsotericModel";
                        break;
                    case "Programming":
                        productModelChild = "BookOnProgrammingModel";
                        break;
                }
                break;
            case "Disks":
                productModelChild = "CompactDiskModel";
                break;
        }
        this.navigator.navigateToProductDetails(this, productListModel.getBarcode(), productModelChild);
    }
}
