package me.sachinsinghdighan.domain.repository.wheather

import me.sachinsinghdighan.domain.model.wheather.CurrentWeatherData
import me.sachinsinghdighan.domain.model.wheather.AQIData
import me.sachinsinghdighan.domain.model.wheather.TrafficFlow
import me.sachinsinghdighan.domain.model.wheather.WeatherAlertResponse


data class WeatherAqiTrafficAlertResult(
    val weatherResult: Result<CurrentWeatherData>?,
    val aqiResult: Result<AQIData>?,
    val trafficResult: Result<TrafficFlow>?,
    val alertsResult: Result<WeatherAlertResponse>?
)

interface WeatherRepository {
    suspend fun getWeatherAqiTrafficAlertParallel(latitude: Double, longitude: Double, location: String): WeatherAqiTrafficAlertResult
}