package com.joerakhimov.niceweather.presentation.di

import com.joerakhimov.niceweather.data.mapper.ForecastDtoMapper
import com.joerakhimov.niceweather.presentation.mapper.ForecastModelMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    fun provideForecastModelMapper() = ForecastModelMapper()

}