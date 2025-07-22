package me.sachinsinghdighan.utils

object ApiConstants {
    // OpenWeatherMap
    const val BASE_URL = "https://api.openweathermap.org/"
    const val API_VERSION = "data/2.5/"
    const val ONE_CALL_ENDPOINT = "data/2.5/weather"
    const val API_KEY = "3b7a2fe1d9f3ab9bfd2f511c66c649fc" // Move to BuildConfig or local.properties

    // AirVisual Air Quality API
    const val AQI_BASE_URL = "https://api.airvisual.com/v2/"
    const val AQI_API_VERSION = "nearest_city"
    const val AQI_ENDPOINT = "nearest_city"
    const val AQI_API_KEY = "ccfa753e-b76d-46b0-b084-300674266ba5" // Move to BuildConfig or local.properties

    // TomTom Traffic API
    const val TRAFFIC_BASE_URL = "https://api.tomtom.com/traffic/services/4/"
    const val TRAFFIC_FLOW_SEGMENT_ENDPOINT = "flowSegmentData/absolute/10/json"
    const val TRAFFIC_API_KEY = "KQApWcJWIt4XFPLsJTTrczBXTponz2MF" // Move to BuildConfig or local.properties

    const val WEATHERAPI_BASE_URL = "https://api.weatherapi.com/v1/"
    const val WEATHERAPI_ALERTS_ENDPOINT = "alerts.json"
    const val WEATHERAPI_API_KEY = "ab6a9f5a03ba4d98ac4175930252107"
}