package com.example.vkedu1.presentation.applist

import androidx.compose.runtime.Immutable
import com.example.vkedu1.domain.AppInfo

@Immutable
sealed interface AppListState {
    data object Loading : AppListState
    data object Error : AppListState
    data class Content(val apps: List<AppInfo>) : AppListState
}
