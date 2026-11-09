package com.example.vkedu1.presentation.appdetails

import androidx.compose.runtime.Immutable
import com.example.vkedu1.domain.AppDetails
import com.example.vkedu1.domain.AppInfo

@Immutable
sealed interface AppDetailsState {
    data object Error : AppDetailsState
    data object Loading : AppDetailsState
    data class Content(
        val appDetails: AppDetails,
        val similarApps: List<AppInfo>,
        val showcaseApps: List<AppInfo>,
        val descriptionCollapsed: Boolean,
    ) : AppDetailsState
}
