package me.sachinsinghdighan.data.remote.api

import me.sachinsinghdighan.data.remote.wheatherdto.WeatherAlertResponseDto
import retrofit2.http.GET
import retrofit2.http.Query
import me.sachinsinghdighan.data.BuildConfig
import me.sachinsinghdighan.utils.ApiConstants

interface WeatherAlertApi {
    @GET(ApiConstants.WEATHERAPI_ALERTS_ENDPOINT)
    suspend fun getWeatherAlerts(
        @Query("key") apiKey: String = ApiConstants.WEATHERAPI_API_KEY,
        @Query("q") location: String
    ): WeatherAlertResponseDto
} 