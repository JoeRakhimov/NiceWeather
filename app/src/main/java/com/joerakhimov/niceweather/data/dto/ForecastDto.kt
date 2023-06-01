package com.joerakhimov.niceweather.data.dto

import android.location.Location

data class ForecastDto(
	val current: CurrentDto? = null,
	val daily: List<DailyItemDto?>? = null,
	val location: LocationDto? = null
)

data class HoursItemDto(
	val temp: Double? = null,
	val condition: String? = null,
	val icon: String? = null,
	val time: String? = null
)

data class CurrentDto(
	val date: String? = null,
	val temp: Double? = null,
	val condition: String? = null,
	val icon: String? = null,
	val time: String? = null
)

data class DailyItemDto(
	val date: String? = null,
	val tempMin: Double? = null,
	val condition: String? = null,
	val hours: List<HoursItemDto?>? = null,
	val icon: String? = null,
	val tempMax: Double? = null
)

data class LocationDto(
	val country: String? = null,
	val latitude: Any? = null,
	val name: String? = null,
	val id: String? = null,
	val region: String? = null,
	val longitude: Any? = null
)

