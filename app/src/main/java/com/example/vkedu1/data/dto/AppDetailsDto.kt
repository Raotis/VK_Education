package com.example.vkedu1.data.dto

/** Карточка приложения в том виде, в котором её «отдаёт сервер». */
data class AppDetailsDto(
    val id: String,
    val name: String,
    val developer: String,
    val category: String,
    val ageRating: Int,
    val size: Double,
    val icon: String,
    val iconColor: String,
    val description: String,
)
