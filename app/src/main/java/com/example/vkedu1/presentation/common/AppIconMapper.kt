package com.example.vkedu1.presentation.common

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
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.vkedu1.domain.AppIconType

/** Domain-тип иконки -> картинка Compose. Это забота presentation, а не domain. */
fun AppIconType.toImageVector(): ImageVector = when (this) {
    AppIconType.PERSON -> Icons.Default.Person
    AppIconType.SEND -> Icons.AutoMirrored.Filled.Send
    AppIconType.LOCATION -> Icons.Default.LocationOn
    AppIconType.CHECK -> Icons.Default.CheckCircle
    AppIconType.PLAY -> Icons.Default.PlayArrow
    AppIconType.STAR -> Icons.Default.Star
    AppIconType.CART -> Icons.Default.ShoppingCart
    AppIconType.FAVORITE -> Icons.Default.Favorite
    AppIconType.INFO -> Icons.Default.Info
    AppIconType.CREATE -> Icons.Default.Create
    AppIconType.HOME -> Icons.Default.Home
}
