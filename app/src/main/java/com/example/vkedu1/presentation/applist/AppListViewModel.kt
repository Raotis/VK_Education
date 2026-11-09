package com.example.vkedu1.presentation.applist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkedu1.domain.GetAppsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel списка приложений. Знает только про use case из domain.
 * Use case приходит из Hilt (@Inject constructor) — вручную ViewModel больше нигде не создаётся.
 */
@HiltViewModel
class AppListViewModel @Inject constructor(
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
    }
}
