package ca.rjreid.faireweather.domain.models

data class FaireWeather(
    var consolidatedWeather: List<ConsolidatedWeather> = arrayListOf(),
    var time: String? = null,
    var sunRise: String? = null,
    var sunSet: String? = null,
    var timezoneName: String? = null,
    var parent: Parent? = Parent(),
    var sources: List<Sources> = arrayListOf(),
    var title: String? = null,
    var locationType: String? = null,
    var woeid: Int? = null,
    var lattLong: String? = null,
    var timezone: String? = null
)