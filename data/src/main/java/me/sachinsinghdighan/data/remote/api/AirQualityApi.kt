package me.sachinsinghdighan.data.remote.api

import me.sachinsinghdighan.data.remote.wheatherdto.AQIDataDto
import retrofit2.http.GET
import retrofit2.http.Query
import me.sachinsinghdighan.data.BuildConfig
import me.sachinsinghdighan.utils.ApiConstants

interface AirQualityApi {
    @GET(ApiConstants.AQI_ENDPOINT)
    suspend fun getAirQuality(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("key") apiKey: String = ApiConstants.AQI_API_KEY
    ): AQIDataDto
} 