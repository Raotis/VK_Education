package com.example.vkedu1.domain

/** Приложение в списке и в «Витрине». Domain-модель: только чистый Kotlin. */
data class AppInfo(
    val id: String,
    val name: String,
    val description: String,
    val category: Category,
    val iconType: AppIconType,
    /** Цвет подложки иконки в формате ARGB, например 0xFF0077FF. */
    val iconColor: Long,
)
