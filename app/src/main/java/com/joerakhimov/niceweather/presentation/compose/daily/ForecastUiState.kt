package com.joerakhimov.niceweather.presentation.compose.daily

import com.joerakhimov.niceweather.presentation.model.DailyItemModel

data class ForecastUiState(
    val dailyForecast: List<DailyItemModel> = listOf(),
    val offline: Boolean = false
)