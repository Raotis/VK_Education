package com.example.vkedu1.data.mapper

import com.example.vkedu1.data.dto.AppDto
import com.example.vkedu1.domain.AppInfo
import javax.inject.Inject

/** DTO -> Domain для приложения из списка. */
class AppMapper @Inject constructor() {
    fun toDomain(dto: AppDto): AppInfo = AppInfo(
        id = dto.id,
        name = dto.name,
        description = dto.description,
        category = mapCategory(dto.category),
        iconType = mapIconType(dto.icon),
        iconColor = mapColor(dto.iconColor),
    )
}
