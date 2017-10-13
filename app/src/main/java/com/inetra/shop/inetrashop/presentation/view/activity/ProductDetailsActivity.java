package com.inetra.shop.inetrashop.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.inetra.shop.inetrashop.R;
import com.inetra.shop.inetrashop.domain.di.HasComponent;
import com.inetra.shop.inetrashop.domain.di.components.DaggerProductComponent;
import com.inetra.shop.inetrashop.domain.di.components.ProductComponent;
import com.inetra.shop.inetrashop.domain.di.modules.ProductModule;
import com.inetra.shop.inetrashop.presentation.view.fragment.ProductDetailsFragment;

public class ProductDetailsActivity extends BaseActivity implements HasComponent<ProductComponent> {
    private static final String INTENT_EXTRA_PARAM_PRODUCT_BARCODE = "INTENT_PARAM_PRODUCT_BARCODE";
    private static final String INTENT_EXTRA_PARAM_PRODUCT_CHILD = "INTENT_PARAM_PRODUCT_CHILD";
    private static final String INSTANCE_STATE_PARAM_PRODUCT_BARCODE = "STATE_PARAM_PRODUCT_BARCODE";
    private static final String INSTANCE_STATE_PARAM_PRODUCT_CHILD = "STATE_PARAM_PRODUCT_CHILD";

    public static Intent getCallingIntent(Context context, String barCode, String productModelChild) {
        Intent callingIntent = new Intent(context, ProductDetailsActivity.class);
        callingIntent.putExtra(INTENT_EXTRA_PARAM_PRODUCT_BARCODE, barCode);
        callingIntent.putExtra(INTENT_EXTRA_PARAM_PRODUCT_CHILD, productModelChild);
        return callingIntent;
    }

    private String barCode;
    private String productModelChild;
    private ProductComponent productComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);

        this.initializeActivity(savedInstanceState);
        this.initializeInjector();
        setTitle("Product Description");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.putString(INSTANCE_STATE_PARAM_PRODUCT_BARCODE, this.barCode);
            outState.putString(INSTANCE_STATE_PARAM_PRODUCT_CHILD, this.productModelChild);
        }
        super.onSaveInstanceState(outState);
    }

    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            this.barCode = getIntent().getStringExtra(INTENT_EXTRA_PARAM_PRODUCT_BARCODE);
            this.productModelChild = getIntent().getStringExtra(INTENT_EXTRA_PARAM_PRODUCT_CHILD);
            addFragment(R.id.fragmentContainer, new ProductDetailsFragment());
        } else {
            this.barCode = savedInstanceState.getString(INSTANCE_STATE_PARAM_PRODUCT_BARCODE);
            this.productModelChild = savedInstanceState.getString(INSTANCE_STATE_PARAM_PRODUCT_CHILD);
        }
    }

    private void initializeInjector() {
        this.productComponent = DaggerProductComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .productModule(new ProductModule(this.barCode, this.productModelChild))
                .build();
    }

    @Override
    public ProductComponent getComponent() {
        return productComponent;
    }
}
