package com.joerakhimov.niceweather.domain.usecase

import com.joerakhimov.niceweather.domain.entity.Forecast
import com.joerakhimov.niceweather.domain.repository.ForecastRepository

class GetForecastUseCase(private val forecastRepository: ForecastRepository) {

    fun getForecast(): Forecast {
        return forecastRepository.getForecast()
    }

}