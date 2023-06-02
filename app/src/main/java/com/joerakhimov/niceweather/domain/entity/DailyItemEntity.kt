package com.joerakhimov.niceweather.domain.entity

data class DailyItemEntity(
    val date: String,
    val tempMin: Double,
    val tempMax: Double,
    val condition: String,
    val icon: String,
    val hourly: List<HourlyItemEntity>
)
