package com.joerakhimov.niceweather.domain.usecase

import com.joerakhimov.niceweather.domain.entity.ForecastEntity
import com.joerakhimov.niceweather.domain.repository.ForecastRepository

class GetForecastByLocationUseCase(private val forecastRepository: ForecastRepository) {

    suspend fun getForecastByLocation(latitude: Double, longitude: Double): ForecastEntity {
        return forecastRepository.getForecastByLocation(latitude, longitude)
    }

}