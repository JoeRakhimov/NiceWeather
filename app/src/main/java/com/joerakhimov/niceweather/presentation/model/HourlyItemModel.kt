package com.joerakhimov.niceweather.presentation.model

data class HourlyItemModel(
    val time: String,
    val temp: Double,
    val condition: String,
    val icon: String
)
