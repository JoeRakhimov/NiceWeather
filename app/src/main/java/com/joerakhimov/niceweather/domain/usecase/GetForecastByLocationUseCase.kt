package com.joerakhimov.niceweather.domain.usecase

import com.joerakhimov.niceweather.domain.entity.Forecast
import com.joerakhimov.niceweather.domain.repository.ForecastRepository

class GetForecastByLocationUseCase(private val forecastRepository: ForecastRepository) {

    fun getForecastByLocation(latitude: Double, longitude: Double): Forecast {
        return forecastRepository.getForecastByLocation(latitude, longitude)
    }

}