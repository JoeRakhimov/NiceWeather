package com.joerakhimov.niceweather.presentation.mapper

import com.joerakhimov.niceweather.domain.entity.DailyItemEntity
import com.joerakhimov.niceweather.domain.entity.ForecastEntity
import com.joerakhimov.niceweather.presentation.model.DailyItemModel
import com.joerakhimov.niceweather.presentation.model.ForecastModel
import com.joerakhimov.niceweather.presentation.model.HourlyItemModel

class ForecastModelMapper {

    fun mapFromEntity(forecastEntity: ForecastEntity): ForecastModel{
        return ForecastModel(
            daily = forecastEntity.daily.map {
                DailyItemModel(
                    date = it.date,
                    tempMin = it.tempMin,
                    tempMax = it.tempMax,
                    condition = it.condition,
                    icon = it.icon,
                    hourly = it.hourly.map {
                        HourlyItemModel(
                            time = it.time,
                            temp = it.temp,
                            condition = it.condition,
                            icon = it.icon
                        )
                    }
                )
            }
        )
    }

}