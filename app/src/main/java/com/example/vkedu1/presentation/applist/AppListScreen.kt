package com.example.vkedu1.presentation.applist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkedu1.data.sampleApps
import com.example.vkedu1.domain.AppInfo
import com.example.vkedu1.ui.theme.VkEdu1Theme

/** Экран «Список приложений»: сверху тулбар, под ним вертикальный список. */
@Composable
fun AppListScreen(
    apps: List<AppInfo>,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { AppListToolbar() },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            // innerPadding учитывает высоту тулбара и системные панели (edge-to-edge)
            contentPadding = innerPadding,
        ) {
            itemsIndexed(items = apps, key = { _, app -> app.id }) { index, app ->
                Column {
                    AppListItem(app = app)
                    if (index < apps.lastIndex) {
                        // 88dp = 16 (отступ) + 56 (иконка) + 16 (промежуток): линия начинается от текста
                        HorizontalDivider(
                            modifier = Modifier.padding(start = 88.dp, end = 16.dp),
                            color = MaterialTheme.colorScheme.outlineVariant,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppListScreenPreview() {
    VkEdu1Theme {
        AppListScreen(apps = sampleApps)
    }
}
