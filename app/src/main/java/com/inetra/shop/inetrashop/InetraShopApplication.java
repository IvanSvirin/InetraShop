package com.inetra.shop.inetrashop;

import android.app.Application;

import com.inetra.shop.inetrashop.domain.di.components.ApplicationComponent;
import com.inetra.shop.inetrashop.domain.di.components.DaggerApplicationComponent;
import com.inetra.shop.inetrashop.domain.di.modules.ApplicationModule;

public class InetraShopApplication extends Application {
  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    this.initializeInjector();
  }

  private void initializeInjector() {
    this.applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
  }
}
