package com.example.vkedu1.data.mapper

import com.example.vkedu1.domain.AppIconType
import com.example.vkedu1.domain.Category

private const val DEFAULT_COLOR_RGB = 0x607D8BL

/** Строка из DTO -> Category. Незнакомая категория считается «Утилиты». */
internal fun mapCategory(value: String): Category = when (value) {
    "Социальные сети" -> Category.SOCIAL
    "Карты" -> Category.MAPS
    "Финансы" -> Category.FINANCE
    "Музыка" -> Category.MUSIC
    "Видео" -> Category.VIDEO
    "Покупки" -> Category.SHOPPING
    "Еда" -> Category.FOOD
    "Образование" -> Category.EDUCATION
    else -> Category.UTILITIES
}

/** Строка из DTO -> AppIconType. Незнакомая иконка заменяется на INFO. */
internal fun mapIconType(value: String): AppIconType = when (value) {
    "person" -> AppIconType.PERSON
    "send" -> AppIconType.SEND
    "location" -> AppIconType.LOCATION
    "check" -> AppIconType.CHECK
    "play" -> AppIconType.PLAY
    "star" -> AppIconType.STAR
    "cart" -> AppIconType.CART
    "favorite" -> AppIconType.FAVORITE
    "create" -> AppIconType.CREATE
    "home" -> AppIconType.HOME
    else -> AppIconType.INFO
}

/** Цвет "#RRGGBB" из DTO -> ARGB-число. Если строка некорректна, берётся серо-синий. */
internal fun mapColor(hex: String): Long {
    val rgb = hex.removePrefix("#").toLongOrNull(16) ?: DEFAULT_COLOR_RGB
    return 0xFF000000L or rgb
}
