package com.joerakhimov.niceweather.data.mapper

import com.joerakhimov.niceweather.data.dto.ForecastDto
import com.joerakhimov.niceweather.domain.entity.DailyItemEntity
import com.joerakhimov.niceweather.domain.entity.ForecastEntity
import com.joerakhimov.niceweather.domain.entity.HourlyItemEntity

class ForecastDtoMapper {

    fun mapToEntity(forecastDto: ForecastDto): ForecastEntity {
        return ForecastEntity(
            daily = forecastDto.daily?.map {
                DailyItemEntity(
                    date = it?.date ?: "",
                    tempMin = it?.temp_min ?: 0.0,
                    tempMax = it?.temp_max ?: 0.0,
                    condition = it?.condition ?: "",
                    icon = it?.icon ?: "",
                    hourly = it?.hours?.map {
                        HourlyItemEntity(
                            time = it?.time ?: "",
                            temp = it?.temp ?: 0.0,
                            condition = it?.condition ?: "",
                            icon = it?.icon ?: ""
                        )
                    } ?: emptyList()
                )
            } ?: emptyList()
        )
    }

}