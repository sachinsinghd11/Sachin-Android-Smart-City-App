package me.sachinsinghdighan.domain.usecase.wheather

import me.sachinsinghdighan.domain.repository.wheather.WeatherRepository
import me.sachinsinghdighan.domain.repository.wheather.WeatherAqiTrafficAlertResult
import javax.inject.Inject

class GetWeatherAirQualityAlertUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(latitude: Double, longitude: Double, location: String): WeatherAqiTrafficAlertResult {
        return repository.getWeatherAqiTrafficAlertParallel(latitude, longitude, location)
    }
}