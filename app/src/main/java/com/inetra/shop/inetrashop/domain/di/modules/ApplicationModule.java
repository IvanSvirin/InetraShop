package com.inetra.shop.inetrashop.domain.di.modules;

import android.content.Context;
import com.inetra.shop.inetrashop.InetraShopApplication;
import com.inetra.shop.inetrashop.UIThread;
import com.inetra.shop.inetrashop.data.cache.BookOnCookingCache;
import com.inetra.shop.inetrashop.data.cache.BookOnCookingCacheImpl;
import com.inetra.shop.inetrashop.data.cache.BookOnEsotericCache;
import com.inetra.shop.inetrashop.data.cache.BookOnEsotericCacheImpl;
import com.inetra.shop.inetrashop.data.cache.BookOnProgrammingCache;
import com.inetra.shop.inetrashop.data.cache.BookOnProgrammingCacheImpl;
import com.inetra.shop.inetrashop.data.cache.CompactDiskCache;
import com.inetra.shop.inetrashop.data.cache.CompactDiskCacheImpl;
import com.inetra.shop.inetrashop.data.executor.JobExecutor;
import com.inetra.shop.inetrashop.data.repository.BookOnCookingDataRepository;
import com.inetra.shop.inetrashop.data.repository.BookOnEsotericDataRepository;
import com.inetra.shop.inetrashop.data.repository.BookOnProgrammingDataRepository;
import com.inetra.shop.inetrashop.data.repository.CompactDiskDataRepository;
import com.inetra.shop.inetrashop.domain.executor.PostExecutionThread;
import com.inetra.shop.inetrashop.domain.executor.ThreadExecutor;
import com.inetra.shop.inetrashop.domain.repository.BookOnCookingRepository;
import com.inetra.shop.inetrashop.domain.repository.BookOnEsotericRepository;
import com.inetra.shop.inetrashop.domain.repository.BookOnProgrammingRepository;
import com.inetra.shop.inetrashop.domain.repository.CompactDiskRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
  private final InetraShopApplication application;

  public ApplicationModule(InetraShopApplication application) {
    this.application = application;
  }

  @Provides
  @Singleton
  Context provideApplicationContext() {
    return this.application;
  }

  @Provides
  @Singleton
  ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides
  @Singleton
  PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }

  @Provides
  @Singleton
  BookOnCookingCache provideBookOnCookingCache(BookOnCookingCacheImpl bookOnCookingCache) {
    return bookOnCookingCache;
  }

  @Provides
  @Singleton
  BookOnCookingRepository provideBookOnCookingRepository(BookOnCookingDataRepository bookOnCookingDataRepository) {
    return bookOnCookingDataRepository;
  }

  @Provides
  @Singleton
  BookOnEsotericCache provideBookOnEsotericCache(BookOnEsotericCacheImpl bookOnEsotericCache) {
    return bookOnEsotericCache;
  }

  @Provides
  @Singleton
  BookOnEsotericRepository provideBookOnEsotericRepository(BookOnEsotericDataRepository bookOnEsotericDataRepository) {
    return bookOnEsotericDataRepository;
  }

  @Provides
  @Singleton
  BookOnProgrammingCache provideBookOnProgrammingCache(BookOnProgrammingCacheImpl bookOnProgrammingCache) {
    return bookOnProgrammingCache;
  }

  @Provides
  @Singleton
  BookOnProgrammingRepository provideBookOnProgrammingRepository(BookOnProgrammingDataRepository bookOnProgrammingDataRepository) {
    return bookOnProgrammingDataRepository;
  }

  @Provides
  @Singleton
  CompactDiskCache provideCompactDiskCache(CompactDiskCacheImpl compactDiskCache) {
    return compactDiskCache;
  }

  @Provides
  @Singleton
  CompactDiskRepository provideCompactDiskRepository(CompactDiskDataRepository compactDiskDataRepository) {
    return compactDiskDataRepository;
  }
}
