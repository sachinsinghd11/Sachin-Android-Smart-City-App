package me.sachinsinghdighan.data.remote.wheatherdto

import com.google.gson.annotations.SerializedName

data class AQIDataDto(
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: AQIDataDetailsDto
)

data class AQIDataDetailsDto(
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("country") val country: String,
    @SerializedName("location") val location: AQILocationDto,
    @SerializedName("current") val current: AQICurrentDto
)

data class AQILocationDto(
    @SerializedName("type") val type: String,
    @SerializedName("coordinates") val coordinates: List<Double>
)

data class AQICurrentDto(
    @SerializedName("pollution") val pollution: AQIPollutionDto,
    @SerializedName("weather") val weather: AQIWeatherDto
)

data class AQIPollutionDto(
    @SerializedName("ts") val ts: String,
    @SerializedName("aqius") val aqius: Int,
    @SerializedName("mainus") val mainus: String,
    @SerializedName("aqicn") val aqicn: Int,
    @SerializedName("maincn") val maincn: String
)

data class AQIWeatherDto(
    @SerializedName("ts") val ts: String,
    @SerializedName("ic") val ic: String,
    @SerializedName("hu") val hu: Int,
    @SerializedName("pr") val pr: Int,
    @SerializedName("tp") val tp: Int,
    @SerializedName("wd") val wd: Int,
    @SerializedName("ws") val ws: Double
) 