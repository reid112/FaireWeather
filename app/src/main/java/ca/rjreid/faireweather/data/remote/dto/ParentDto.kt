package ca.rjreid.faireweather.data.remote.dto

import com.squareup.moshi.Json

data class ParentDto(
    @field:Json(name = "title") var title: String? = null,
    @field:Json(name = "location_type") var locationType: String? = null,
    @field:Json(name = "woeid") var woeid: Int? = null,
    @field:Json(name = "latt_long") var lattLong: String? = null
)