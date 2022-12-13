package ca.rjreid.faireweather.data.remote.api

import ca.rjreid.faireweather.data.remote.dto.FaireWeatherDto
import retrofit2.http.GET
import retrofit2.http.Path

interface FaireWeatherApi  {
    @GET("static/mobile-take-home/{id}.json")
    suspend fun fetchWeatherForLocation(@Path("id") locationId: Int): FaireWeatherDto
}