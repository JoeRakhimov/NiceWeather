package com.joerakhimov.niceweather.domain.entity

data class DailyEntity(
    val date: String,
    val tempMin: Double,
    val tempMax: Double,
    val condition: String,
    val icon: String
)
