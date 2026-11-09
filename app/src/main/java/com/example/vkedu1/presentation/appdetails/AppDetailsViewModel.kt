package com.example.vkedu1.presentation.appdetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkedu1.domain.GetAppDetailsUseCase
import com.example.vkedu1.domain.GetShowcaseAppsUseCase
import com.example.vkedu1.domain.GetSimilarAppsUseCase
import com.example.vkedu1.presentation.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel карточки приложения. Знает только про use case'ы из domain;
 * id приложения берёт из аргумента навигации (Hilt сам кладёт его в SavedStateHandle).
 * Use case'ы приходят из Hilt (@Inject constructor).
 */
@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getAppDetailsUseCase: GetAppDetailsUseCase,
    private val getSimilarAppsUseCase: GetSimilarAppsUseCase,
    private val getShowcaseAppsUseCase: GetShowcaseAppsUseCase,
) : ViewModel() {

    private val appId: String = savedStateHandle.get<String>(Routes.ARG_APP_ID).orEmpty()

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    private var loadingJob: Job? = null

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
        loadingJob?.cancel()
        loadingJob = viewModelScope.launch {
            _state.value = AppDetailsState.Loading
            try {
                val appDetails = getAppDetailsUseCase(appId)
                if (appDetails == null) {
                    _state.value = AppDetailsState.Error
                } else {
                    _state.value = AppDetailsState.Content(
                        appDetails = appDetails,
                        similarApps = getSimilarAppsUseCase(appId),
                        showcaseApps = getShowcaseAppsUseCase(),
                        descriptionCollapsed = false,
                    )
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load app details", e)
                _state.value = AppDetailsState.Error
            }
        }
    }

    companion object {
        private const val TAG = "AppDetailsViewModel"
    }
}
