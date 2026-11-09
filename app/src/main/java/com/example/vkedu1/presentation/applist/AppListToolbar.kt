package com.example.vkedu1.presentation.applist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import com.example.vkedu1.R
import com.example.vkedu1.ui.theme.VkEdu1Theme

/** Тулбар: слева иконка текущего приложения, фон — акцентный цвет темы (primary). */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListToolbar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                fontWeight = FontWeight.Bold,
            )
        },
        navigationIcon = {
            CurrentAppIcon(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .size(36.dp),
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        modifier = modifier,
    )
}

/**
 * Иконка самого приложения (launcher-иконка).
 *
 * painterResource(R.mipmap.ic_launcher) здесь использовать нельзя: иконка адаптивная,
 * и Compose падает с "Only VectorDrawables and rasterized asset types are supported".
 * Поэтому берём Drawable у PackageManager и превращаем его в картинку.
 */
@Composable
private fun CurrentAppIcon(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val iconBitmap = remember(context) {
        runCatching {
            context.packageManager
                .getApplicationIcon(context.packageName)
                .toBitmap(width = 192, height = 192)
                .asImageBitmap()
        }.getOrNull()
    }

    if (iconBitmap != null) {
        Image(
            bitmap = iconBitmap,
            contentDescription = "Иконка приложения",
            modifier = modifier.clip(RoundedCornerShape(8.dp)),
        )
    } else {
        // Запасной вариант, если иконку получить не удалось (например, в превью)
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Иконка приложения",
            modifier = modifier,
        )
    }
}

@Preview
@Composable
private fun AppListToolbarPreview() {
    VkEdu1Theme {
        AppListToolbar()
    }
}
