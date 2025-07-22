package me.sachinsinghdighan.data.remote.api

import me.sachinsinghdighan.data.remote.wheatherdto.CurrentWeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query
import me.sachinsinghdighan.data.BuildConfig
import me.sachinsinghdighan.utils.ApiConstants

interface WeatherApi {
    @GET(ApiConstants.ONE_CALL_ENDPOINT)
    suspend fun getWeatherData(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String = ApiConstants.API_KEY,
        @Query("units") units: String = "metric"
    ): CurrentWeatherResponseDto
}