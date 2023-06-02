package com.joerakhimov.niceweather.domain.entity

data class HourlyItemEntity(
    val time: String,
    val temp: Double,
    val condition: String,
    val icon: String
)
