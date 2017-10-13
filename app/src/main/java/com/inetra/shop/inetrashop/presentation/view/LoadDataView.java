package com.inetra.shop.inetrashop.presentation.view;

import android.content.Context;

interface LoadDataView {

  void showLoading();

  void hideLoading();

  void showRetry();

  void hideRetry();

  void showError(String message);

  Context context();
}
