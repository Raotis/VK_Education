package com.example.vkedu1.di

import com.example.vkedu1.data.AppsApi
import com.example.vkedu1.data.AppsRepositoryImpl
import com.example.vkedu1.data.mapper.AppDetailsMapper
import com.example.vkedu1.data.mapper.AppMapper
import com.example.vkedu1.domain.AppsRepository
import com.example.vkedu1.domain.GetAppDetailsUseCase
import com.example.vkedu1.domain.GetAppsUseCase
import com.example.vkedu1.domain.GetShowcaseAppsUseCase
import com.example.vkedu1.domain.GetSimilarAppsUseCase

/**
 * Ручной DI: единственное место, которое знает про все слои и собирает объекты.
 * ViewModel'и берут отсюда готовые use case'ы.
 */
object AppContainer {
    private val repository: AppsRepository by lazy {
        AppsRepositoryImpl(
            api = AppsApi(),
            appMapper = AppMapper(),
            appDetailsMapper = AppDetailsMapper(),
        )
    }

    val getAppsUseCase: GetAppsUseCase by lazy { GetAppsUseCase(repository) }
    val getShowcaseAppsUseCase: GetShowcaseAppsUseCase by lazy { GetShowcaseAppsUseCase(repository) }
    val getAppDetailsUseCase: GetAppDetailsUseCase by lazy { GetAppDetailsUseCase(repository) }
    val getSimilarAppsUseCase: GetSimilarAppsUseCase by lazy { GetSimilarAppsUseCase(repository) }
}
