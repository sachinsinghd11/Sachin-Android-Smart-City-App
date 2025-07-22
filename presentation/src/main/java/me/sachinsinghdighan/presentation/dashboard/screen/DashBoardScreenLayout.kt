package me.sachinsinghdighan.presentation.dashboard.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import me.sachinsinghdighan.domain.repository.wheather.WeatherAqiTrafficAlertResult
import me.sachinsinghdighan.presentation.R
import me.sachinsinghdighan.presentation.base.Route
import me.sachinsinghdighan.presentation.base.UiState
import me.sachinsinghdighan.presentation.dashboard.WeatherViewModel
import me.sachinsinghdighan.presentation.dashboard.screen.apptitlebar.SmartCityAppTitleBar
import me.sachinsinghdighan.presentation.dashboard.screen.cityalerts.CityAlertLayout
import me.sachinsinghdighan.presentation.dashboard.screen.miscellaneousservice.Miscellaneous
import me.sachinsinghdighan.presentation.dashboard.screen.miscellaneousservice.MiscellaneousLayout
import me.sachinsinghdighan.presentation.dashboard.screen.quickstats.quickstatslayout.QuickStatsWithTitleLayout
import java.net.URLEncoder

@Composable
fun DashBoardScreenLayout(
    latitude: Double = 33.44,
    longitude: Double = -94.04,
    location: String = "Germany",
    viewModel: WeatherViewModel = hiltViewModel(),
    navController: NavController = rememberNavController(),
    innerPadding: PaddingValues = PaddingValues(0.dp)
) {
    val weatherAqiTrafficAlertState by viewModel.weatherAqiTrafficAlertState.collectAsStateWithLifecycle()

    LaunchedEffect(latitude, longitude, location) {
        viewModel.getWeatherAqiTrafficAlertParallel(latitude, longitude, location)
    }

    Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
        when (weatherAqiTrafficAlertState) {
            is UiState.Loading -> DashboardLoadingView()
            is UiState.Error -> DashboardErrorView((weatherAqiTrafficAlertState as UiState.Error).message)
            is UiState.Success -> DashboardSuccessView(
                (weatherAqiTrafficAlertState as UiState.Success).data as WeatherAqiTrafficAlertResult,
                navController
            )
        }
    }
}

@Composable
fun DashboardLoadingView() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun DashboardErrorView(message: String) {
    Text(
        text = message,
        modifier = Modifier,
        color = androidx.compose.material3.MaterialTheme.colorScheme.error
    )
}

@Composable
fun DashboardSuccessView(result: WeatherAqiTrafficAlertResult, navController: NavController) {
    val weatherResult = result.weatherResult
    val aqiResult = result.aqiResult
    val trafficResult = result.trafficResult
    val alertsResult = result.alertsResult

    val weatherData = weatherResult?.getOrNull()
    val aqiData = aqiResult?.getOrNull()
    val trafficData = trafficResult?.getOrNull()
    val alertsData = alertsResult?.getOrNull()
    val weatherError = weatherResult?.exceptionOrNull()?.localizedMessage
    val aqiError = aqiResult?.exceptionOrNull()?.localizedMessage
    val trafficError = trafficResult?.exceptionOrNull()?.localizedMessage
    val alertsError = alertsResult?.exceptionOrNull()?.localizedMessage

    val miscellaneousList = listOf(
        Miscellaneous(image = R.mipmap.ic_public_transport, title = "Public Transport"),
        Miscellaneous(image = R.mipmap.ic_plus_sign, title = "Emergency Services"),
        Miscellaneous(image = R.mipmap.ic_bin, title = "Waste Management"),
        Miscellaneous(image = R.mipmap.ic_calendar, title = "City\nEvents"),
    )

    if (weatherData == null && aqiData == null && trafficData == null && alertsData == null) {
        Text(
            text = "Failed to fetch Weather, AQI, Traffic, and Alerts data.\n" +
                    (weatherError ?: "") + "\n" +
                    (aqiError ?: "") + "\n" +
                    (trafficError ?: "") + "\n" +
                    (alertsError ?: ""),
            modifier = Modifier,
            color = androidx.compose.material3.MaterialTheme.colorScheme.error
        )
    } else {
        val temperature = weatherData?.main?.temp?.let { "${it.toInt()}°C" } ?: "--"
        val condition = weatherData?.weather?.firstOrNull()?.description ?: "--"
        val iconCode = weatherData?.weather?.firstOrNull()?.icon
        val imageUrl = iconCode?.let { "https://openweathermap.org/img/wn/${it}@2x.png" } ?: ""
        val aqi = aqiData?.data?.current?.pollution?.aqius
        val aqiText = aqi?.let { "AQI : $it" } ?: "AQI unavailable"
        val aqiCondition = aqi?.let {
            when {
                it <= 50 -> "Good"
                it in 51..100 -> "Moderate"
                else -> "Bad"
            }
        } ?: "--"
        val trafficSpeed = trafficData?.flowSegmentData?.currentSpeed
        val freeFlowSpeed = trafficData?.flowSegmentData?.freeFlowSpeed
        val trafficConfidence = trafficData?.flowSegmentData?.confidence?.toString() ?: "--"
        val trafficClosure = trafficData?.flowSegmentData?.roadClosure?.toString() ?: "--"
        val trafficSpeedText = trafficSpeed?.toString() ?: "--"
        // Traffic Status Logic
        val trafficStatus = if (trafficSpeed != null && freeFlowSpeed != null) {
            when {
                trafficSpeed >= (freeFlowSpeed * 0.9) -> "No Traffic"
                trafficSpeed >= (freeFlowSpeed * 0.6) -> "Moderate Traffic"
                else -> "Heavy Traffic"
            }
        } else {
            "--"
        }
        Column(modifier = Modifier.padding(8.dp)) {
            SmartCityAppTitleBar(modifier = Modifier)
            QuickStatsWithTitleLayout(
                imageUrl = imageUrl,
                temperature = temperature,
                condition = condition,
                aqiData = aqiText,
                aqiCondition = aqiCondition,
                trafficStatus = trafficStatus,
                modifier = Modifier
            )
            // Alerts UI
            /*if (alertsData?.alerts?.alert?.isNotEmpty() == true) {
                Text("City Alerts:", color = Color.Red)
                alertsData.alerts?.alert?.forEach { alert ->
                    Text(text = alert.headline ?: "", color = Color.Red)
                    Text(text = alert.desc ?: "", color = Color.Gray)
                }
            }*/
            if (weatherError != null && weatherData == null) {
                Text("Weather Error: $weatherError", color = Color.Red)
            }
            if (aqiError != null && aqiData == null) {
                Text("AQI Error: $aqiError", color = Color.Red)
            }
            if (trafficError != null && trafficData == null) {
                Text("Traffic Error: $trafficError", color = Color.Red)
            }
            if (alertsError != null && alertsData == null) {
                Text("Alerts Error: $alertsError", color = Color.Red)
            }
            MiscellaneousLayout(miscellaneousList, modifier = Modifier)
            CityAlertLayout(
                alertsData = alertsData?.alerts?.alert?: emptyList(),
                modifier = Modifier,
                onAlertClick = { alert ->
                    val alertJson = URLEncoder.encode(Gson().toJson(alert), "UTF-8")
                    navController.navigate(Route.CityAlertDetail.createRoute(alertJson))
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashBoardScreenLayoutPreview() {
    DashBoardScreenLayout()
}