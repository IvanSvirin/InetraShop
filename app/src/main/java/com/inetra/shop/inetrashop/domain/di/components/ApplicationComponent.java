package com.inetra.shop.inetrashop.domain.di.components;

import android.content.Context;

import com.inetra.shop.inetrashop.domain.di.modules.ApplicationModule;
import com.inetra.shop.inetrashop.domain.executor.PostExecutionThread;
import com.inetra.shop.inetrashop.domain.executor.ThreadExecutor;
import com.inetra.shop.inetrashop.domain.repository.BookOnCookingRepository;
import com.inetra.shop.inetrashop.domain.repository.BookOnEsotericRepository;
import com.inetra.shop.inetrashop.domain.repository.BookOnProgrammingRepository;
import com.inetra.shop.inetrashop.domain.repository.CompactDiskRepository;
import com.inetra.shop.inetrashop.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  void inject(BaseActivity baseActivity);

  Context context();
  ThreadExecutor threadExecutor();
  PostExecutionThread postExecutionThread();
  BookOnCookingRepository bookOnCookingRepository();
  BookOnEsotericRepository bookOnEsotericRepository();
  BookOnProgrammingRepository bookOnProgrammingRepository();
  CompactDiskRepository compactDiskRepository();
}
