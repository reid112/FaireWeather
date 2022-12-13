package ca.rjreid.faireweather.domain.models


data class ConsolidatedWeather(
    var id: Long? = null,
    var weatherStateName: String? = null,
    var weatherStateAbbr: String? = null,
    var windDirectionCompass: String? = null,
    var created: String? = null,
    var applicableDate: String? = null,
    var minTemp: Double? = null,
    var maxTemp: Double? = null,
    var theTemp: Double? = null,
    var windSpeed: Double? = null,
    var windDirection: Double? = null,
    var airPressure: Double? = null,
    var humidity: Int? = null,
    var visibility: Double? = null,
    var predictability: Int? = null
)