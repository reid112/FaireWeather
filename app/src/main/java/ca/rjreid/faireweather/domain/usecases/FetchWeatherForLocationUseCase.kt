package ca.rjreid.faireweather.domain.usecases

import ca.rjreid.faireweather.data.remote.repository.FaireWeatherRepository
import ca.rjreid.faireweather.domain.mappers.toFaireWeather
import ca.rjreid.faireweather.domain.models.FaireWeather
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface FetchWeatherForLocationUseCase {
    sealed interface UseCaseResult {
        object Loading : UseCaseResult
        data class Success(val weather: FaireWeather) : UseCaseResult
        data class Error(val message: String) : UseCaseResult
    }

    suspend operator fun invoke(id: Int): Flow<UseCaseResult>
}

class FetchWeatherForLocationUseCaseImpl @Inject constructor(
    private val repository: FaireWeatherRepository
) : FetchWeatherForLocationUseCase {
    override suspend fun invoke(id: Int): Flow<FetchWeatherForLocationUseCase.UseCaseResult> = flow {
        emit(FetchWeatherForLocationUseCase.UseCaseResult.Loading)

        // Add a delay of half a second here to simulate a little bit longer loading
        delay(500)

        try {
            val response = repository.fetchWeatherForLocation(id = id)
            emit(FetchWeatherForLocationUseCase.UseCaseResult.Success(response.toFaireWeather()))
        } catch (ex: Throwable) {
            emit(FetchWeatherForLocationUseCase.UseCaseResult.Error(ex.message.toString()))
        }
    }
}