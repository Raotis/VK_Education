package com.example.vkedu1.data.dto

/** Приложение в том виде, в котором его «отдаёт сервер»: одни строки и числа. */
data class AppDto(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val icon: String,
    val iconColor: String,
)
