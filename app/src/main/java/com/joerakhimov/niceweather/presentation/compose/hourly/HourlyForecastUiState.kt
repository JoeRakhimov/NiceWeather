package com.joerakhimov.niceweather.presentation.compose.hourly

import com.joerakhimov.niceweather.presentation.model.HourlyItemModel

data class HourlyForecastUiState(
    val hourlyForecast: List<HourlyItemModel> = listOf()
)