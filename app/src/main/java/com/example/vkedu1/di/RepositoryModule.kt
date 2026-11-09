package com.example.vkedu1.di

import com.example.vkedu1.data.AppsRepositoryImpl
import com.example.vkedu1.domain.AppsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Говорит Hilt: «там, где просят интерфейс AppsRepository, выдавай AppsRepositoryImpl».
 * Поэтому ViewModel и use case знают только про интерфейс из domain, а реализацию подставляет DI.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAppsRepository(impl: AppsRepositoryImpl): AppsRepository
}
