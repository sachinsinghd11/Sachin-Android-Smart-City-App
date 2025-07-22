package me.sachinsinghdighan.domain.model.wheather

data class AQIData(
    val status: String,
    val data: AQIDataDetails
)

data class AQIDataDetails(
    val city: String,
    val state: String,
    val country: String,
    val location: AQILocation,
    val current: AQICurrent
)

data class AQILocation(
    val type: String,
    val coordinates: List<Double>
)

data class AQICurrent(
    val pollution: AQIPollution,
    val weather: AQIWeather
)

data class AQIPollution(
    val ts: String,
    val aqius: Int,
    val mainus: String,
    val aqicn: Int,
    val maincn: String
)

data class AQIWeather(
    val ts: String,
    val ic: String,
    val hu: Int,
    val pr: Int,
    val tp: Int,
    val wd: Int,
    val ws: Double
) 