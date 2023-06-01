package com.joerakhimov.niceweather.presentation.mapper

import com.joerakhimov.niceweather.domain.entity.DailyItemEntity
import com.joerakhimov.niceweather.domain.entity.ForecastEntity
import com.joerakhimov.niceweather.presentation.model.DailyItemModel
import com.joerakhimov.niceweather.presentation.model.ForecastModel

class ForecastModelMapper {

    fun mapFromEntity(forecastEntity: ForecastEntity): ForecastModel{
        return ForecastModel(
            daily = forecastEntity.daily.map {
                DailyItemModel(
                    date = it.date,
                    tempMin = it.tempMin,
                    tempMax = it.tempMax,
                    condition = it.condition,
                    icon = it.icon
                )
            }
        )
    }

}