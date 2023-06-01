package com.joerakhimov.niceweather.domain.di

import com.joerakhimov.niceweather.domain.repository.ForecastRepository
import com.joerakhimov.niceweather.domain.usecase.GetForecastUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetForecastUseCase(forecastRepository: ForecastRepository) = GetForecastUseCase(forecastRepository)

}