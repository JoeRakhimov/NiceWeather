package com.joerakhimov.niceweather.domain.repository

import com.joerakhimov.niceweather.domain.entity.Forecast

interface ForecastRepository {

    fun getForecast(): Forecast
    fun getForecastByLocation(latitude: Double, longitude: Double): Forecast

}