package com.example.vkedu1.presentation.appdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkedu1.data.findAppDetails
import com.example.vkedu1.data.sampleApps
import com.example.vkedu1.data.showcaseApps
import com.example.vkedu1.presentation.navigation.Routes
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * ViewModel карточки приложения. В примере данные приходят из сети и базы через Hilt,
 * здесь они захардкожены, а id приложения берётся из аргумента навигации.
 */
class AppDetailsViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val appId: String = savedStateHandle.get<String>(Routes.ARG_APP_ID).orEmpty()

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        getAppDetails()
    }

    fun showUnderDevelopmentMessage() {
        viewModelScope.launch {
            _events.send(AppDetailsEvent.UnderDevelopment)
        }
    }

    fun collapseDescription() {
        val currentState = _state.value
        if (currentState is AppDetailsState.Content) {
            _state.value = currentState.copy(descriptionCollapsed = true)
        }
    }

    fun getAppDetails() {
        val appDetails = findAppDetails(appId)
        _state.value = if (appDetails == null) {
            AppDetailsState.Error
        } else {
            AppDetailsState.Content(
                appDetails = appDetails,
                similarApps = sampleApps.filter { it.id != appId }.take(SIMILAR_APPS_COUNT),
                showcaseApps = showcaseApps,
                descriptionCollapsed = false,
            )
        }
    }

    private companion object {
        const val SIMILAR_APPS_COUNT = 6
    }
}
