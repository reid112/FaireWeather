package ca.rjreid.faireweather.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ca.rjreid.faireweather.R
import ca.rjreid.faireweather.domain.models.ConsolidatedWeather
import ca.rjreid.faireweather.domain.models.FaireWeather
import ca.rjreid.faireweather.ui.components.ScreenTitle
import ca.rjreid.faireweather.ui.components.WeatherIcon

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .navigationBarsPadding()
            .clickable { viewModel.onEvent(UiEvent.OnRefresh) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            if (uiState.loading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            uiState.weather?.let { weather ->
                WeatherData(uiState.location, weather)
            }

            uiState.error?.let { error ->
                WeatherError(error)
            }
            
            if (!uiState.loading && uiState.weather == null && uiState.error == null) {
                EmptyState()
            }
        }
    }
}

@Composable
private fun WeatherData(location: String?, weather: ConsolidatedWeather) {
    val unknownWeather = stringResource(id = R.string.label_unknown_weather)

    Column(modifier = Modifier.fillMaxWidth()) {
        ScreenTitle(
            modifier = Modifier.padding(vertical = 16.dp),
            title = location ?: stringResource(id = R.string.label_unknown_location)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            weather.weatherStateAbbr?.let {
                WeatherIcon(
                    modifier = Modifier.height(60.dp),
                    weatherStateAbbr = it,
                    weatherType = weather.weatherStateName ?: ""
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = stringResource(
                    id = R.string.label_current_temp,
                    weather.theTemp?.toInt() ?: unknownWeather
                ),
                style = MaterialTheme.typography.h1
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            text = weather.weatherStateName ?: unknownWeather,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(
                id = R.string.label_low_high_temp,
                weather.minTemp?.toInt() ?: unknownWeather,
                weather.maxTemp?.toInt() ?: unknownWeather
            ),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun WeatherError(error: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        text = error,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Center,
    )
}

@Composable
private fun EmptyState() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        text = stringResource(id = R.string.label_empty_state),
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Center,
    )
}