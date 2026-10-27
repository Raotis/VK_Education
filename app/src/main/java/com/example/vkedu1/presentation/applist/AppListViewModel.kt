package com.example.vkedu1.presentation.applist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.vkedu1.di.AppContainer
import com.example.vkedu1.domain.GetAppsUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/** ViewModel списка приложений. Знает только про use case из domain. */
class AppListViewModel(
    private val getAppsUseCase: GetAppsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state = _state.asStateFlow()

    private var loadingJob: Job? = null

    init {
        loadApps()
    }

    fun loadApps() {
        loadingJob?.cancel()
        loadingJob = viewModelScope.launch {
            _state.value = AppListState.Loading
            try {
                _state.value = AppListState.Content(getAppsUseCase())
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load apps", e)
                _state.value = AppListState.Error
            }
        }
    }

    companion object {
        private const val TAG = "AppListViewModel"

        /** Фабрика: объясняет Android, как создать ViewModel с зависимостями. */
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                AppListViewModel(getAppsUseCase = AppContainer.getAppsUseCase)
            }
        }
    }
}
