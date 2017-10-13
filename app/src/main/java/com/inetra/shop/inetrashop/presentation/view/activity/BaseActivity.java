package com.inetra.shop.inetrashop.presentation.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.inetra.shop.inetrashop.InetraShopApplication;
import com.inetra.shop.inetrashop.domain.di.components.ApplicationComponent;
import com.inetra.shop.inetrashop.domain.di.modules.ActivityModule;
import com.inetra.shop.inetrashop.presentation.navigation.Navigator;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity {
  @Inject
  Navigator navigator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.getApplicationComponent().inject(this);
  }

  protected void addFragment(int containerViewId, Fragment fragment) {
    FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
    fragmentTransaction.add(containerViewId, fragment);
    fragmentTransaction.commit();
  }

  protected ApplicationComponent getApplicationComponent() {
    return ((InetraShopApplication) getApplicationContext()).getApplicationComponent();
  }

  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }
}
