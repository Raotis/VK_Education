package com.example.vkedu1.data

import com.example.vkedu1.data.dto.AppDetailsDto
import com.example.vkedu1.data.dto.AppDto

private const val SHOWCASE_SIZE = 9

// Представим, что этот класс ходит в сеть. Пока вместо запросов — захардкоженные DTO.
class AppsApi {
    suspend fun getApps(): List<AppDto> = appDtos

    /** Витрина: ровно 9 приложений (3 страницы по 3). */
    suspend fun getShowcaseApps(): List<AppDto> = appDtos.take(SHOWCASE_SIZE)

    suspend fun getAppDetails(id: String): AppDetailsDto? =
        appDetailsDtos.firstOrNull { it.id == id }
}
