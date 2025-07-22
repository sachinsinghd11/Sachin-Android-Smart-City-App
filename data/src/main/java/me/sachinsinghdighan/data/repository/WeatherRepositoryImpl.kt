package me.sachinsinghdighan.data.repository

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import me.sachinsinghdighan.data.mapper.wheather.toDomainModel
import me.sachinsinghdighan.data.remote.api.AirQualityApi
import me.sachinsinghdighan.data.remote.api.TrafficApi
import me.sachinsinghdighan.data.remote.api.WeatherAlertApi
import me.sachinsinghdighan.data.remote.api.WeatherApi
import me.sachinsinghdighan.domain.repository.wheather.WeatherAqiTrafficAlertResult
import me.sachinsinghdighan.domain.repository.wheather.WeatherRepository
import me.sachinsinghdighan.utils.ApiConstants
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val airQualityApi: AirQualityApi,
    private val trafficApi: TrafficApi,
    private val weatherAlertApi: WeatherAlertApi
) : WeatherRepository {

    override suspend fun getWeatherAqiTrafficAlertParallel(
        latitude: Double,
        longitude: Double,
        location: String,
    ): WeatherAqiTrafficAlertResult = coroutineScope {
        val point = "$latitude,$longitude"
        val weatherDeferred = async {
            try {
                val weather = weatherApi.getWeatherData(latitude, longitude).toDomainModel()
                Result.success(weather)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
        val aqiDeferred = async {
            try {
                val aqi = airQualityApi.getAirQuality(latitude, longitude).toDomainModel()
                Result.success(aqi)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
        val trafficDeferred = async {
            try {
                val traffic = trafficApi.getTrafficFlow(point).toDomainModel()
                Result.success(traffic)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
        val alertsDeferred = async {
            try {
                val alerts = weatherAlertApi.getWeatherAlerts(location = location).toDomainModel()
                Result.success(alerts)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
        WeatherAqiTrafficAlertResult(
            weatherResult = weatherDeferred.await(),
            aqiResult = aqiDeferred.await(),
            trafficResult = trafficDeferred.await(),
            alertsResult = alertsDeferred.await()
        )
    }
}