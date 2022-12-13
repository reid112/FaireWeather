package ca.rjreid.faireweather.util

sealed class Screen(val route: String) {
    object Home: Screen(Routes.HOME.route)
}

enum class Routes(val route: String) {
    HOME("home")
}