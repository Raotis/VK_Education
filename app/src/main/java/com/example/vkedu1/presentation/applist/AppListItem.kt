package com.example.vkedu1.presentation.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkedu1.domain.AppInfo
import com.example.vkedu1.domain.Category
import com.example.vkedu1.presentation.common.AppIcon
import com.example.vkedu1.presentation.common.previewApp
import com.example.vkedu1.presentation.common.title
import com.example.vkedu1.presentation.common.toImageVector
import com.example.vkedu1.ui.theme.VkEdu1Theme

/**
 * Один элемент списка: иконка, название, краткое описание и категория.
 * Переиспользуется и в списке приложений, и в блоке «Витрина».
 *
 * minDescriptionLines = 2 резервирует место под две строки описания, чтобы все элементы
 * были одной высоты (нужно, чтобы страницы «Витрины» не «прыгали» по высоте при свайпе).
 */
@Composable
fun AppListItem(
    app: AppInfo,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    minDescriptionLines: Int = 1,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AppIcon(
            icon = app.iconType.toImageVector(),
            background = Color(app.iconColor),
        )
        Spacer(Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = app.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = app.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                minLines = minDescriptionLines,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(Modifier.height(6.dp))
            CategoryLabel(category = app.category)
        }
    }
}

@Composable
private fun CategoryLabel(
    category: Category,
    modifier: Modifier = Modifier,
) {
    Text(
        text = category.title,
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.onSecondaryContainer,
        modifier = modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(horizontal = 8.dp, vertical = 2.dp),
    )
}

@Preview(showBackground = true)
@Composable
private fun AppListItemPreview() {
    VkEdu1Theme {
        AppListItem(app = previewApp, onClick = {})
    }
}
