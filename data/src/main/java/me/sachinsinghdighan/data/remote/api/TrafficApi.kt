package me.sachinsinghdighan.data.remote.api

import me.sachinsinghdighan.data.remote.wheatherdto.TrafficFlowDto
import retrofit2.http.GET
import retrofit2.http.Query
import me.sachinsinghdighan.data.BuildConfig
import me.sachinsinghdighan.utils.ApiConstants

interface TrafficApi {
    @GET(ApiConstants.TRAFFIC_FLOW_SEGMENT_ENDPOINT)
    suspend fun getTrafficFlow(
        @Query("point") point: String, // "lat,lon"
        @Query("key") apiKey: String = ApiConstants.TRAFFIC_API_KEY
    ): TrafficFlowDto
} 