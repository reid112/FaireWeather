package ca.rjreid.faireweather.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.rjreid.faireweather.domain.usecases.FetchWeatherForLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val fetchWeatherForLocationUseCase: FetchWeatherForLocationUseCase
) : ViewModel() {
    //region Companion
    companion object {
        private const val ID = 4418
    }
    //endregion

    //region Variables
    var uiState by mutableStateOf(UiState())
        private set
    //endregion

    //region Init
    init {
        fetchWeather()
    }

    //region Public
    fun onEvent(event: UiEvent) {
        when (event) {
            is UiEvent.OnRefresh -> {
                fetchWeather()
            }
        }
    }
    //endregion

    //region Helpers
    private fun fetchWeather() {
        viewModelScope.launch {
            fetchWeatherForLocationUseCase(ID).collectLatest { result ->
                uiState = when (result) {
                    is FetchWeatherForLocationUseCase.UseCaseResult.Loading -> {
                        uiState.loading()
                    }
                    is FetchWeatherForLocationUseCase.UseCaseResult.Success -> {
                        uiState.weather(weather = result.weather)
                    }
                    is FetchWeatherForLocationUseCase.UseCaseResult.Error -> {
                        uiState.error(result.message)
                    }
                }
            }
        }
    }
    //endregion
}