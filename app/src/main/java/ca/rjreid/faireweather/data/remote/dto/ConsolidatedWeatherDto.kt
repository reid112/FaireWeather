package ca.rjreid.faireweather.data.remote.dto

import com.squareup.moshi.Json

data class ConsolidatedWeatherDto(
    @field:Json(name = "id") var id: Long? = null,
    @field:Json(name = "weather_state_name") var weatherStateName: String? = null,
    @field:Json(name = "weather_state_abbr") var weatherStateAbbr: String? = null,
    @field:Json(name = "wind_direction_compass") var windDirectionCompass: String? = null,
    @field:Json(name = "created") var created: String? = null,
    @field:Json(name = "applicable_date") var applicableDate: String? = null,
    @field:Json(name = "min_temp") var minTemp: Double? = null,
    @field:Json(name = "max_temp") var maxTemp: Double? = null,
    @field:Json(name = "the_temp") var theTemp: Double? = null,
    @field:Json(name = "wind_speed") var windSpeed: Double? = null,
    @field:Json(name = "wind_direction") var windDirection: Double? = null,
    @field:Json(name = "air_pressure") var airPressure: Double? = null,
    @field:Json(name = "humidity") var humidity: Int? = null,
    @field:Json(name = "visibility") var visibility: Double? = null,
    @field:Json(name = "predictability") var predictability: Int? = null
)