package com.example.vkedu1.presentation.applist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vkedu1.domain.AppInfo
import com.example.vkedu1.presentation.appdetails.AppDetailsError
import com.example.vkedu1.presentation.appdetails.AppDetailsLoading
import com.example.vkedu1.presentation.common.previewApps
import com.example.vkedu1.ui.theme.VkEdu1Theme

/**
 * Экран «Список приложений». Получает состояние от ViewModel и рисует его.
 * Сам ничего не загружает: данные приходят из ViewModel -> use case -> репозиторий.
 */
@Composable
fun AppListScreen(
    onAppClick: (AppInfo) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppListViewModel = viewModel(factory = AppListViewModel.Factory),
) {
    val state by viewModel.state.collectAsState()

    AppListContent(
        state = state,
        onAppClick = onAppClick,
        onRetryClick = viewModel::loadApps,
        modifier = modifier,
    )
}

@Composable
private fun AppListContent(
    state: AppListState,
    onAppClick: (AppInfo) -> Unit,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { AppListToolbar() },
    ) { innerPadding ->
        when (state) {
            is AppListState.Loading -> {
                // Готовые компоненты загрузки и ошибки переиспользуем с экрана карточки
                AppDetailsLoading(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                )
            }

            is AppListState.Error -> {
                AppDetailsError(
                    onRefreshClick = onRetryClick,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                )
            }

            is AppListState.Content -> {
                AppList(
                    apps = state.apps,
                    onAppClick = onAppClick,
                    contentPadding = innerPadding,
                )
            }
        }
    }
}

@Composable
private fun AppList(
    apps: List<AppInfo>,
    onAppClick: (AppInfo) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        // contentPadding учитывает высоту тулбара и системные панели (edge-to-edge)
        contentPadding = contentPadding,
    ) {
        itemsIndexed(items = apps, key = { _, app -> app.id }) { index, app ->
            Column {
                AppListItem(app = app, onClick = { onAppClick(app) })
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

@Preview(showBackground = true)
@Composable
private fun AppListScreenPreview() {
    VkEdu1Theme {
        AppListContent(
            state = AppListState.Content(previewApps),
            onAppClick = {},
            onRetryClick = {},
        )
    }
}
