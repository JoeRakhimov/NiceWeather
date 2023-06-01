package com.joerakhimov.niceweather.data.api

import com.joerakhimov.niceweather.data.dto.ForecastDto

interface ForecastApi {

    suspend fun getForecast(): ForecastDto

}