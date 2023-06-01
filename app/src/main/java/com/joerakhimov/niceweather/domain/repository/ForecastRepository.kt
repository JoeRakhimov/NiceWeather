package com.joerakhimov.niceweather.domain.repository

import com.joerakhimov.niceweather.domain.entity.ForecastEntity

interface ForecastRepository {

    suspend fun getForecast(): ForecastEntity
    suspend fun getForecastByLocation(latitude: Double, longitude: Double): ForecastEntity

}