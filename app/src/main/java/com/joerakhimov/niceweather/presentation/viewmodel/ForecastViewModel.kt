package com.joerakhimov.niceweather.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joerakhimov.niceweather.domain.usecase.GetForecastUseCase
import com.joerakhimov.niceweather.presentation.mapper.ForecastModelMapper
import com.joerakhimov.niceweather.presentation.model.DailyItemModel
import kotlinx.coroutines.launch

class ForecastViewModel(
    private val getForecastUseCase: GetForecastUseCase,
    private val forecastModelMapper: ForecastModelMapper
) : ViewModel() {

    private val dailyForecast = MutableLiveData<List<DailyItemModel>>()

    init {
        getForecast()
    }

    private fun getForecast() {
        viewModelScope.launch {
            val forecastModel = forecastModelMapper.mapFromEntity(getForecastUseCase.getForecast())
            dailyForecast.value = forecastModel.daily
        }
    }

}