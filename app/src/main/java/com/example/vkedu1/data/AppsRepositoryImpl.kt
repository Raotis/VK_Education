package com.example.vkedu1.data

import com.example.vkedu1.data.mapper.AppDetailsMapper
import com.example.vkedu1.data.mapper.AppMapper
import com.example.vkedu1.domain.AppDetails
import com.example.vkedu1.domain.AppInfo
import com.example.vkedu1.domain.AppsRepository

/** Реализация репозитория: берёт DTO из «сети» и превращает их мапперами в domain-модели. */
class AppsRepositoryImpl(
    private val api: AppsApi,
    private val appMapper: AppMapper,
    private val appDetailsMapper: AppDetailsMapper,
) : AppsRepository {

    override suspend fun getApps(): List<AppInfo> =
        api.getApps().map(appMapper::toDomain)

    override suspend fun getShowcaseApps(): List<AppInfo> =
        api.getShowcaseApps().map(appMapper::toDomain)

    override suspend fun getAppDetails(id: String): AppDetails? =
        api.getAppDetails(id)?.let(appDetailsMapper::toDomain)
}
