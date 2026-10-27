package com.example.vkedu1.domain

/** Контракт репозитория. Живёт в domain, а реализация — в data. */
interface AppsRepository {
    suspend fun getApps(): List<AppInfo>

    suspend fun getShowcaseApps(): List<AppInfo>

    /** Карточка приложения или null, если приложения с таким id нет. */
    suspend fun getAppDetails(id: String): AppDetails?
}
