package com.inetra.shop.inetrashop.presentation.view.activity;

import android.os.Bundle;
import android.widget.Button;

import com.inetra.shop.inetrashop.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.btn_LoadData)
    Button btn_LoadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_LoadData)
    void navigateToProductList() {
        this.navigator.navigateToProductList(this);
    }
}
