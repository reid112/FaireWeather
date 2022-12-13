package ca.rjreid.faireweather.di

import ca.rjreid.faireweather.data.remote.repository.FaireWeatherRepository
import ca.rjreid.faireweather.domain.usecases.FetchWeatherForLocationUseCase
import ca.rjreid.faireweather.domain.usecases.FetchWeatherForLocationUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun providesFetchWeatherForLocationUseCase(repository: FaireWeatherRepository): FetchWeatherForLocationUseCase {
        return FetchWeatherForLocationUseCaseImpl(repository)
    }
}