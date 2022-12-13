package ca.rjreid.faireweather.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ca.rjreid.faireweather.ui.theme.FaireWeatherTheme

@Composable
fun ScreenTitle(
    modifier: Modifier = Modifier,
    title: String,
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = title,
        style = MaterialTheme.typography.h3
    )
}

//region Preview
@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
private fun LightPreview() {
    FaireWeatherTheme(darkTheme = false) {
        ScreenTitle(title = "Toronto")
    }
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
private fun DarkPreview() {
    FaireWeatherTheme(darkTheme = true) {
        ScreenTitle(title = "Toronto")
    }
}
//endregion