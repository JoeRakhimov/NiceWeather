package com.joerakhimov.niceweather.data.api

import com.joerakhimov.niceweather.data.dto.ForecastDto
import retrofit2.http.GET

interface ForecastApi {

    @GET("/forecast")
    suspend fun getForecast(): ForecastDto

}