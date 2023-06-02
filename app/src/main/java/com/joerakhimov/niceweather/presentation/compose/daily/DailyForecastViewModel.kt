package com.joerakhimov.niceweather.presentation.compose.daily

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joerakhimov.niceweather.domain.usecase.GetForecastUseCase
import com.joerakhimov.niceweather.presentation.compose.daily.ForecastUiState
import com.joerakhimov.niceweather.presentation.mapper.ForecastModelMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DailyForecastViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase,
    private val forecastModelMapper: ForecastModelMapper
) : ViewModel() {

    var uiState by mutableStateOf(ForecastUiState())
        private set

    init {
        getForecast()
    }

    private fun getForecast() {
        viewModelScope.launch {
            val forecastModel = forecastModelMapper.mapFromEntity(getForecastUseCase.getForecast())
            uiState = uiState.copy(
                dailyForecast = forecastModel.daily,
                offline = false
            )
        }
    }

}