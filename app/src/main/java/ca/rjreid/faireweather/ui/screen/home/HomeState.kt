package ca.rjreid.faireweather.ui.screen.home

import ca.rjreid.faireweather.domain.models.ConsolidatedWeather
import ca.rjreid.faireweather.domain.models.FaireWeather

data class UiState(
    val loading: Boolean = true,
    val location: String? = null,
    val weather: ConsolidatedWeather? = null,
    val error: String? = null
) {
    fun loading(): UiState {
        return this.copy(
            loading = true,
            location = null,
            weather = null,
            error = null
        )
    }

    fun weather(weather: FaireWeather): UiState {
        return this.copy(
            loading = false,
            location = weather.title,
            weather = weather.consolidatedWeather.random(),
            error = null
        )
    }

    fun error(error: String): UiState {
        return this.copy(
            loading = false,
            location = null,
            weather = null,
            error = error
        )
    }
}

sealed interface UiEvent {
    object OnRefresh : UiEvent
}
