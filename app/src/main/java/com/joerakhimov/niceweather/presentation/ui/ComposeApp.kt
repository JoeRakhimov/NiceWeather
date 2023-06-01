package com.joerakhimov.niceweather.presentation.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.joerakhimov.niceweather.presentation.ui.forecast.ForecastScreen

@Composable
fun ComposeApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.DAILY_FORECAST
    ) {
        composable(Route.DAILY_FORECAST) { backStackEntry ->
            ForecastScreen(
                onUserClick = { date ->
                    // In order to discard duplicated navigation events, we check the Lifecycle
                    if (backStackEntry.lifecycle.currentState == Lifecycle.State.RESUMED) {
                        navController.navigate("${Route.HOURLY_FORECAST}/$date")
                    }
                }
            )
        }
    }
}

object Route {
    const val DAILY_FORECAST = "daily"
    const val HOURLY_FORECAST = "hourly"
}