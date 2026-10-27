package com.example.vkedu1.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/** Иконка приложения: белый значок на цветной скруглённой подложке. Используется на всех экранах. */
@Composable
fun AppIcon(
    icon: ImageVector,
    background: Color,
    modifier: Modifier = Modifier,
    size: Dp = 56.dp,
    cornerRadius: Dp = 14.dp,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(cornerRadius))
            .background(background),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null, // название приложения всегда есть рядом текстом
            tint = Color.White,
            modifier = Modifier.size(size * 0.57f),
        )
    }
}
