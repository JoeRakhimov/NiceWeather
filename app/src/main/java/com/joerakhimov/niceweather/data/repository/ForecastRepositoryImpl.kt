package com.joerakhimov.niceweather.data.repository

import com.joerakhimov.niceweather.data.api.ForecastApi
import com.joerakhimov.niceweather.data.mapper.ForecastMapper
import com.joerakhimov.niceweather.domain.entity.ForecastEntity
import com.joerakhimov.niceweather.domain.repository.ForecastRepository

class ForecastRepositoryImpl(
    private val forecastApi: ForecastApi,
    private val forecastMapper: ForecastMapper
) : ForecastRepository {

    override suspend fun getForecast(): ForecastEntity {
        val forecastDto = forecastApi.getForecast()
        return forecastMapper.mapToEntity(forecastDto)
    }

    override suspend fun getForecastByLocation(
        latitude: Double,
        longitude: Double
    ): ForecastEntity {
        TODO("Not yet implemented")
    }

}