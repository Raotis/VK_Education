package com.example.vkedu1.data.mapper

import com.example.vkedu1.data.dto.AppDetailsDto
import com.example.vkedu1.domain.AppDetails

/** DTO -> Domain для карточки приложения. */
class AppDetailsMapper {
    fun toDomain(dto: AppDetailsDto): AppDetails = AppDetails(
        id = dto.id,
        name = dto.name,
        developer = dto.developer,
        category = mapCategory(dto.category),
        ageRating = dto.ageRating,
        size = dto.size.toFloat(),
        iconType = mapIconType(dto.icon),
        iconColor = mapColor(dto.iconColor),
        description = dto.description,
    )
}
