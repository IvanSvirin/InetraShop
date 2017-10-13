package com.inetra.shop.inetrashop.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import com.inetra.shop.inetrashop.presentation.view.activity.ProductDetailsActivity;
import com.inetra.shop.inetrashop.presentation.view.activity.ProductListActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Navigator {
  @Inject
  Navigator() {
    //empty
  }

  public void navigateToProductDetails(Context context, String barCode, String productModelChild) {
    if (context != null) {
      Intent intentToLaunch = ProductDetailsActivity.getCallingIntent(context, barCode, productModelChild);
      context.startActivity(intentToLaunch);
    }
  }


  public void navigateToProductList(Context context) {
    Intent intentToLaunch = ProductListActivity.getCallingIntent(context);
    context.startActivity(intentToLaunch);
  }
}
