package ca.rjreid.faireweather.data.remote.dto

import com.squareup.moshi.Json

data class FaireWeatherDto(
    @field:Json(name = "consolidated_weather") var consolidatedWeather: List<ConsolidatedWeatherDto> = listOf(),
    @field:Json(name = "time") var time: String? = null,
    @field:Json(name = "sun_rise") var sunRise: String? = null,
    @field:Json(name = "sun_set") var sunSet: String? = null,
    @field:Json(name = "timezone_name") var timezoneName: String? = null,
    @field:Json(name = "parent") var parent: ParentDto? = ParentDto(),
    @field:Json(name = "sources") var sources: List<SourcesDto> = listOf(),
    @field:Json(name = "title") var title: String? = null,
    @field:Json(name = "location_type") var locationType: String? = null,
    @field:Json(name = "woeid") var woeid: Int? = null,
    @field:Json(name = "latt_long") var lattLong: String? = null,
    @field:Json(name = "timezone") var timezone: String? = null
)