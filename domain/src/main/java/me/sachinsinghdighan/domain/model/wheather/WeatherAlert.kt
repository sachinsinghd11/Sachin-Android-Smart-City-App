package me.sachinsinghdighan.domain.model.wheather

data class WeatherAlertLocation(
    val name: String?,
    val region: String?,
    val country: String?,
    val lat: Double?,
    val lon: Double?,
    val tzId: String?,
    val localtimeEpoch: Long?,
    val localtime: String?
)

data class WeatherAlertItem(
    val headline: String?,
    val msgType: String?,
    val severity: String?,
    val urgency: String?,
    val areas: String?,
    val category: String?,
    val certainty: String?,
    val event: String?,
    val note: String?,
    val effective: String?,
    val expires: String?,
    val desc: String?,
    val instruction: String?
)

data class WeatherAlerts(
    val alert: List<WeatherAlertItem>?
)

data class WeatherAlertResponse(
    val location: WeatherAlertLocation?,
    val alerts: WeatherAlerts?
) 