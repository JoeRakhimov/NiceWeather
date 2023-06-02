package com.joerakhimov.niceweather.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joerakhimov.niceweather.domain.usecase.GetForecastUseCase
import com.joerakhimov.niceweather.presentation.compose.daily.ForecastUiState
import com.joerakhimov.niceweather.presentation.mapper.ForecastModelMapper
import com.joerakhimov.niceweather.presentation.model.ForecastModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class ForecastIntent {
    object GetForecastIntent : ForecastIntent()
}

sealed class ForecastState {
    object LoadingState : ForecastState()
    data class DataState(val forecast: ForecastModel) : ForecastState()
}

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase,
    private val forecastModelMapper: ForecastModelMapper
) : ViewModel() {

    private val intents = Channel<ForecastIntent>()

    private val _state = MutableLiveData<ForecastState>()
    val state: LiveData<ForecastState> = _state

    init {
        intents.receiveAsFlow()
            .onEach(::updateState)
            .launchIn(viewModelScope)
        intents.trySend(ForecastIntent.GetForecastIntent)
    }

    fun handleIntent(intent: ForecastIntent) {
        intents.trySend(intent)
    }

    private fun updateState(intent: ForecastIntent){
        when(intent){
            is ForecastIntent.GetForecastIntent -> getForecast()
        }
    }

    private fun getForecast() {
        _state.value = ForecastState.LoadingState
        viewModelScope.launch {
            val forecast = forecastModelMapper.mapFromEntity(getForecastUseCase.getForecast())
            _state.value = ForecastState.DataState(forecast)
        }
    }

}