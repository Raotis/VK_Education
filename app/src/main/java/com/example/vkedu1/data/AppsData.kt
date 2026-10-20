package com.example.vkedu1.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.Color
import com.example.vkedu1.domain.AppInfo
import com.example.vkedu1.domain.Category

/** Захардкоженный список приложений для экрана. */
val sampleApps: List<AppInfo> = listOf(
    AppInfo(
        id = "vk",
        name = "ВКонтакте",
        description = "Общение с друзьями, сообщества, музыка и видео",
        category = Category.SOCIAL,
        icon = Icons.Default.Person,
        iconBackground = Color(0xFF0077FF),
    ),
    AppInfo(
        id = "telegram",
        name = "Telegram",
        description = "Мессенджер с чатами, каналами и ботами",
        category = Category.SOCIAL,
        icon = Icons.AutoMirrored.Filled.Send,
        iconBackground = Color(0xFF229ED9),
    ),
    AppInfo(
        id = "maps",
        name = "Яндекс Карты",
        description = "Карты, навигация и маршруты по городу",
        category = Category.MAPS,
        icon = Icons.Default.LocationOn,
        iconBackground = Color(0xFF00897B),
    ),
    AppInfo(
        id = "bank",
        name = "Сбербанк Онлайн",
        description = "Переводы, платежи и управление счетами",
        category = Category.FINANCE,
        icon = Icons.Default.CheckCircle,
        iconBackground = Color(0xFF21A038),
    ),
    AppInfo(
        id = "music",
        name = "Яндекс Музыка",
        description = "Треки, подборки и персональные рекомендации",
        category = Category.MUSIC,
        icon = Icons.Default.PlayArrow,
        iconBackground = Color(0xFF8E24AA),
    ),
    AppInfo(
        id = "kinopoisk",
        name = "Кинопоиск",
        description = "Фильмы и сериалы, рейтинги и новинки проката",
        category = Category.VIDEO,
        icon = Icons.Default.Star,
        iconBackground = Color(0xFFEF6C00),
    ),
    AppInfo(
        id = "ozon",
        name = "Ozon",
        description = "Интернет-магазин с доставкой и пунктами выдачи",
        category = Category.SHOPPING,
        icon = Icons.Default.ShoppingCart,
        iconBackground = Color(0xFF3F51B5),
    ),
    AppInfo(
        id = "food",
        name = "Яндекс Еда",
        description = "Доставка еды из ресторанов и продуктов из магазинов",
        category = Category.FOOD,
        icon = Icons.Default.Favorite,
        iconBackground = Color(0xFFE91E63),
    ),
    AppInfo(
        id = "gosuslugi",
        name = "Госуслуги",
        description = "Документы, штрафы и записи к врачу онлайн",
        category = Category.UTILITIES,
        icon = Icons.Default.Info,
        iconBackground = Color(0xFF607D8B),
    ),
    AppInfo(
        id = "duolingo",
        name = "Duolingo",
        description = "Изучение языков в формате коротких игровых уроков",
        category = Category.EDUCATION,
        icon = Icons.Default.Create,
        iconBackground = Color(0xFF795548),
    ),
    AppInfo(
        id = "home",
        name = "Умный дом",
        description = "Управление светом, розетками и камерами с телефона",
        category = Category.UTILITIES,
        icon = Icons.Default.Home,
        iconBackground = Color(0xFF455A64),
    ),
)
