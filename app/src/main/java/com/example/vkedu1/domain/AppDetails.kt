package com.example.vkedu1.domain

/** Карточка приложения. Domain-модель: только чистый Kotlin. */
data class AppDetails(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconType: AppIconType,
    /** Цвет подложки иконки в формате ARGB, например 0xFF0077FF. */
    val iconColor: Long,
    val description: String,
)
