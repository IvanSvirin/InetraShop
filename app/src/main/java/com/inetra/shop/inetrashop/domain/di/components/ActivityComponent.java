package com.inetra.shop.inetrashop.domain.di.components;

import android.app.Activity;

import com.inetra.shop.inetrashop.domain.di.PerActivity;
import com.inetra.shop.inetrashop.domain.di.modules.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {

    Activity activity();
}
