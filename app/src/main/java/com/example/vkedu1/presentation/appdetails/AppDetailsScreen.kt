package com.example.vkedu1.presentation.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vkedu1.R
import com.example.vkedu1.domain.AppInfo
import kotlinx.coroutines.flow.Flow

/**
 * Экран карточки приложения (из практического репозитория).
 *
 * @param onBackClick нажата кнопка «назад» в тулбаре
 * @param onShowcaseAppClick нажато приложение в блоке «Витрина»
 */
@Composable
fun AppDetailsScreen(
    onBackClick: () -> Unit,
    onShowcaseAppClick: (AppInfo) -> Unit,
) {
    val viewModel = viewModel<AppDetailsViewModel>()
    val state by viewModel.state.collectAsState()
    val events = viewModel.events

    val snackbarHostState = remember { SnackbarHostState() }

    ObserveEvents(
        events = events,
        snackbarHostState = snackbarHostState,
    )

    // Отступы от системных панелей (статус-бар, навигация) уже учитывает Scaffold — contentPadding.
    // Отдельный safeDrawingPadding() здесь не нужен: он дал бы двойной отступ сверху.
    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        modifier = Modifier.background(MaterialTheme.colorScheme.surface)
    ) { contentPadding ->
        when (val currentState = state) {
            is AppDetailsState.Loading -> {
                AppDetailsLoading(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding),
                )
            }

            is AppDetailsState.Error -> {
                AppDetailsError(
                    onRefreshClick = { viewModel.getAppDetails() },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding),
                )
            }

            is AppDetailsState.Content -> {
                AppDetailsContent(
                    content = currentState,
                    onBackClick = onBackClick,
                    onShareClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    onInstallClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    onReadMoreClick = {
                        viewModel.collapseDescription()
                    },
                    onSimilarAppDownloadClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    onShowcaseAppClick = onShowcaseAppClick,
                    onDeveloperClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding),
                )
            }
        }
    }
}

@Composable
private fun ObserveEvents(
    events: Flow<AppDetailsEvent>,
    snackbarHostState: SnackbarHostState,
) {
    val underDevelopementText = stringResource(R.string.under_development)

    LaunchedEffect(Unit) {
        events.collect { event ->
            when (event) {
                is AppDetailsEvent.UnderDevelopment -> {
                    snackbarHostState.showSnackbar(underDevelopementText)
                }
            }
        }
    }
}
