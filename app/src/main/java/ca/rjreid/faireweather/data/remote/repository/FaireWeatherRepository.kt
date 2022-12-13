package ca.rjreid.faireweather.data.remote.repository

import ca.rjreid.faireweather.data.remote.api.FaireWeatherApi
import ca.rjreid.faireweather.data.remote.dto.FaireWeatherDto

interface FaireWeatherRepository {
    suspend fun fetchWeatherForLocation(id: Int): FaireWeatherDto
}

class FaireWeatherRepositoryImpl(
    private val api: FaireWeatherApi,
) : FaireWeatherRepository {
    override suspend fun fetchWeatherForLocation(id: Int): FaireWeatherDto {
        return api.fetchWeatherForLocation(id)
    }
}