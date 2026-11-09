package com.example.vkedu1.presentation.common

import com.example.vkedu1.domain.Category

/** Название категории для экрана (как getCategoryText в примере). */
val Category.title: String
    get() = when (this) {
        Category.SOCIAL -> "Социальные сети"
        Category.MAPS -> "Карты"
        Category.FINANCE -> "Финансы"
        Category.MUSIC -> "Музыка"
        Category.VIDEO -> "Видео"
        Category.SHOPPING -> "Покупки"
        Category.FOOD -> "Еда"
        Category.EDUCATION -> "Образование"
        Category.UTILITIES -> "Утилиты"
    }
