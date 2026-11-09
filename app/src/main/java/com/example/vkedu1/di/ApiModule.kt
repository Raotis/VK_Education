package com.example.vkedu1.di

import com.example.vkedu1.data.AppsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Объясняет Hilt, как создать объект, у которого нет @Inject-конструктора.
 * Сейчас AppsApi — «заглушка сети»; с настоящим Retrofit здесь был бы его builder.
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideAppsApi(): AppsApi = AppsApi()
}
