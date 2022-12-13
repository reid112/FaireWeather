package ca.rjreid.faireweather.di

import ca.rjreid.faireweather.BuildConfig
import ca.rjreid.faireweather.data.remote.api.FaireWeatherApi
import ca.rjreid.faireweather.data.remote.repository.FaireWeatherRepository
import ca.rjreid.faireweather.data.remote.repository.FaireWeatherRepositoryImpl
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    fun providesFaireWeatherRepository(api: FaireWeatherApi): FaireWeatherRepository {
        return FaireWeatherRepositoryImpl(api)
    }

    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }

        return builder.build()
    }

    @Provides
    fun providesApi(client: OkHttpClient, moshi: Moshi): FaireWeatherApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(FaireWeatherApi::class.java)
    }
}

const val BASE_URL = "https://cdn.faire.com/"