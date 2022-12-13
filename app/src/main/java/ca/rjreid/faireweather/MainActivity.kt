package ca.rjreid.faireweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import ca.rjreid.faireweather.ui.theme.FaireWeatherTheme
import ca.rjreid.faireweather.util.NavGraph
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FaireWeatherTheme {
                FaireWeatherApp()
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FaireWeatherApp() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberAnimatedNavController()
    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(color = MaterialTheme.colors.background)

    Scaffold(
        scaffoldState = scaffoldState,
    ) {
        NavGraph(navController = navController)
    }
}