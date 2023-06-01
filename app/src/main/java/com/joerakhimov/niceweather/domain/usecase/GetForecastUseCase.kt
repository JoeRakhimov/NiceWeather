package com.joerakhimov.niceweather.domain.usecase

import com.joerakhimov.niceweather.domain.entity.ForecastEntity
import com.joerakhimov.niceweather.domain.repository.ForecastRepository

class GetForecastUseCase(private val forecastRepository: ForecastRepository) {

    suspend fun getForecast(): ForecastEntity {
        return forecastRepository.getForecast()
    }

}