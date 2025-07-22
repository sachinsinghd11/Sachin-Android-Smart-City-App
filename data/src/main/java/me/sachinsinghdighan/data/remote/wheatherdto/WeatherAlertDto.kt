package me.sachinsinghdighan.data.remote.wheatherdto

import com.google.gson.annotations.SerializedName

// Location DTO
data class WeatherAlertLocationDto(
    @SerializedName("name") val name: String?,
    @SerializedName("region") val region: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("lat") val lat: Double?,
    @SerializedName("lon") val lon: Double?,
    @SerializedName("tz_id") val tzId: String?,
    @SerializedName("localtime_epoch") val localtimeEpoch: Long?,
    @SerializedName("localtime") val localtime: String?
)

// Alert DTO
data class WeatherAlertItemDto(
    @SerializedName("headline") val headline: String?,
    @SerializedName("msgtype") val msgType: String?,
    @SerializedName("severity") val severity: String?,
    @SerializedName("urgency") val urgency: String?,
    @SerializedName("areas") val areas: String?,
    @SerializedName("category") val category: String?,
    @SerializedName("certainty") val certainty: String?,
    @SerializedName("event") val event: String?,
    @SerializedName("note") val note: String?,
    @SerializedName("effective") val effective: String?,
    @SerializedName("expires") val expires: String?,
    @SerializedName("desc") val desc: String?,
    @SerializedName("instruction") val instruction: String?
)

data class WeatherAlertsDto(
    @SerializedName("alert") val alert: List<WeatherAlertItemDto>?
)

data class WeatherAlertResponseDto(
    @SerializedName("location") val location: WeatherAlertLocationDto?,
    @SerializedName("alerts") val alerts: WeatherAlertsDto?
) 