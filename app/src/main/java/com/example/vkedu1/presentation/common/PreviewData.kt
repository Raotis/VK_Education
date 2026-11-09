package com.example.vkedu1.presentation.common

import com.example.vkedu1.domain.AppDetails
import com.example.vkedu1.domain.AppIconType
import com.example.vkedu1.domain.AppInfo
import com.example.vkedu1.domain.Category

// Данные только для @Preview. presentation не должен импортировать data,
// поэтому для превью собираем domain-модели прямо здесь.

internal val previewApp = AppInfo(
    id = "preview",
    name = "Telegram",
    description = "Мессенджер с чатами, каналами и ботами",
    category = Category.SOCIAL,
    iconType = AppIconType.SEND,
    iconColor = 0xFF229ED9,
)

internal val previewApps: List<AppInfo> = List(9) { index ->
    previewApp.copy(id = "preview-$index", name = "Приложение ${index + 1}")
}

internal val previewAppDetails = AppDetails(
    id = "preview",
    name = "Telegram",
    developer = "Telegram FZ-LLC",
    category = Category.SOCIAL,
    ageRating = 16,
    size = 74.2f,
    iconType = AppIconType.SEND,
    iconColor = 0xFF229ED9,
    description = "Быстрый и безопасный мессенджер. Создавайте чаты и группы, подписывайтесь " +
        "на каналы, пользуйтесь ботами и отправляйте файлы любого типа.",
)
