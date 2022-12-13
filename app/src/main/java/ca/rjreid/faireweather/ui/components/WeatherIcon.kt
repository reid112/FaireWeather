package ca.rjreid.faireweather.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ca.rjreid.faireweather.R
import coil.compose.AsyncImage

@Composable
fun WeatherIcon(
    modifier: Modifier = Modifier,
    weatherStateAbbr: String,
    weatherType: String
) {
    AsyncImage(
        modifier = modifier,
        model = "https://cdn.faire.com/static/mobile-take-home/icons/$weatherStateAbbr.png",
        contentDescription = stringResource(id = R.string.content_description_weather_icon, weatherType)
    )
}