package me.sachinsinghdighan.data.remote.wheatherdto

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponseDto(
    @SerializedName("coord") val coord: CoordDto,
    @SerializedName("weather") val weather: List<WeatherDto>,
    @SerializedName("base") val base: String,
    @SerializedName("main") val main: MainDto,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("wind") val wind: WindDto,
    @SerializedName("clouds") val clouds: CloudsDto,
    @SerializedName("dt") val dt: Long,
    @SerializedName("sys") val sys: SysDto,
    @SerializedName("timezone") val timezone: Int,
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("cod") val cod: Int
)

data class CoordDto(
    @SerializedName("lon") val lon: Double,
    @SerializedName("lat") val lat: Double
)

data class WeatherDto(
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)

data class MainDto(
    @SerializedName("temp") val temp: Double,
    @SerializedName("feels_like") val feelsLike: Double,
    @SerializedName("temp_min") val tempMin: Double,
    @SerializedName("temp_max") val tempMax: Double,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("sea_level") val seaLevel: Int?,
    @SerializedName("grnd_level") val grndLevel: Int?
)

data class WindDto(
    @SerializedName("speed") val speed: Double,
    @SerializedName("deg") val deg: Int
)

data class CloudsDto(
    @SerializedName("all") val all: Int
)

data class SysDto(
    @SerializedName("type") val type: Int?,
    @SerializedName("id") val id: Int?,
    @SerializedName("country") val country: String,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long
) 