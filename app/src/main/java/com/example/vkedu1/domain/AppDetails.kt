package com.example.vkedu1.domain

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Карточка приложения (структура как в примере из репозитория).
 * Вместо iconUrl — векторная иконка на цветной подложке, как в списке приложений.
 */
data class AppDetails(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val icon: ImageVector,
    val iconBackground: Color,
    val description: String,
)
