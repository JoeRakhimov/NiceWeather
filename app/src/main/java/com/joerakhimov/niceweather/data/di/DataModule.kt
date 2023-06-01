package com.joerakhimov.niceweather.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.joerakhimov.niceweather.data.api.ForecastApi
import com.joerakhimov.niceweather.data.mapper.ForecastDtoMapper
import com.joerakhimov.niceweather.data.repository.ForecastRepositoryImpl
import com.joerakhimov.niceweather.domain.repository.ForecastRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor.Builder(context).build())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("http://weather.joerakhimov.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideForecastApi(retrofit: Retrofit): ForecastApi =
        retrofit.create(ForecastApi::class.java)

    @Provides
    fun provideForecastDtoMapper() = ForecastDtoMapper()

    @Provides
    @Singleton
    fun provideForecastRepository(
        forecastApi: ForecastApi,
        forecastDtoMapper: ForecastDtoMapper
    ): ForecastRepository = ForecastRepositoryImpl(forecastApi, forecastDtoMapper)

}