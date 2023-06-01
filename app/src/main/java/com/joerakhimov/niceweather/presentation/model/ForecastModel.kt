package com.joerakhimov.niceweather.presentation.model

import com.joerakhimov.niceweather.domain.entity.DailyItemEntity

data class ForecastModel(
    val daily: List<DailyItemModel>
)
