package ca.rjreid.faireweather.domain.mappers

import ca.rjreid.faireweather.data.remote.dto.ConsolidatedWeatherDto
import ca.rjreid.faireweather.data.remote.dto.FaireWeatherDto
import ca.rjreid.faireweather.data.remote.dto.ParentDto
import ca.rjreid.faireweather.data.remote.dto.SourcesDto
import ca.rjreid.faireweather.domain.models.ConsolidatedWeather
import ca.rjreid.faireweather.domain.models.FaireWeather
import ca.rjreid.faireweather.domain.models.Parent
import ca.rjreid.faireweather.domain.models.Sources

fun FaireWeatherDto.toFaireWeather() = FaireWeather(
    consolidatedWeather = consolidatedWeather.map { it.toConsolidatedWeather() },
    time = time,
    sunRise = sunRise,
    sunSet = sunSet,
    timezoneName = timezoneName,
    parent = parent?.toParent(),
    sources = sources.map { it.toSources() },
    title = title,
    locationType = locationType,
    woeid = woeid,
    lattLong = lattLong,
    timezone = timezone
)

fun ConsolidatedWeatherDto.toConsolidatedWeather() = ConsolidatedWeather(
    id = id,
    weatherStateName = weatherStateName,
    weatherStateAbbr = weatherStateAbbr,
    windDirectionCompass = windDirectionCompass,
    created = created,
    applicableDate = applicableDate,
    minTemp = minTemp,
    maxTemp = maxTemp,
    theTemp = theTemp,
    windSpeed = windSpeed,
    windDirection = windDirection,
    airPressure = airPressure,
    humidity = humidity,
    visibility = visibility,
    predictability = predictability
)

fun ParentDto.toParent() = Parent(
    title = title,
    locationType = locationType,
    woeid = woeid,
    lattLong = lattLong
)

fun SourcesDto.toSources() = Sources(
    title = title,
    slug = slug,
    url = url,
    crawlRate = crawlRate
)