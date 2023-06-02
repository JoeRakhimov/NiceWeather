package com.joerakhimov.niceweather.presentation.model

data class DailyItemModel(
    val date: String,
    val tempMin: Double,
    val tempMax: Double,
    val condition: String,
    val icon: String,
    val hourly: List<HourlyItemModel>
)
