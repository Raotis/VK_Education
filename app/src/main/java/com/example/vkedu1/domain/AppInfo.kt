package com.example.vkedu1.domain

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/** Категория приложения (как в примере из репозитория, только сокращённый набор). */
enum class Category(val title: String) {
    SOCIAL("Социальные сети"),
    MAPS("Карты"),
    FINANCE("Финансы"),
    MUSIC("Музыка"),
    VIDEO("Видео"),
    SHOPPING("Покупки"),
    FOOD("Еда"),
    EDUCATION("Образование"),
    UTILITIES("Утилиты"),
}

/**
 * Приложение в списке.
 *
 * В примере из репозитория иконка задаётся ссылкой (iconUrl) и грузится через Coil.
 * Здесь данные захардкожены, поэтому иконка — это векторная картинка на цветной подложке:
 * так экран работает без интернета и без дополнительных библиотек.
 */
data class AppInfo(
    val id: String,
    val name: String,
    val description: String,
    val category: Category,
    val icon: ImageVector,
    val iconBackground: Color,
)
