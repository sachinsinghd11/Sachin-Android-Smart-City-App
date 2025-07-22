package me.sachinsinghdighan.presentation.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import me.sachinsinghdighan.domain.model.wheather.WeatherAlertItem
import me.sachinsinghdighan.presentation.cityalertdetail.CityAlertDetailScreenLayout
import me.sachinsinghdighan.presentation.dashboard.DashboardScreenRoute
import java.net.URLDecoder

sealed class Route(val name: String) {
    data object Dashboard : Route("dashboard")
    data object CityAlertDetail : Route("city_alert_detail/{alertJson}") {
        fun createRoute(alertJson: String) = "city_alert_detail/$alertJson"
    }
}

@Composable
fun SmartCityNavHost(){
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Route.Dashboard.name
    ) {
        composable(route = Route.Dashboard.name) {
            DashboardScreenRoute(navController = navController)
        }
        composable(
            route = Route.CityAlertDetail.name,
            arguments = listOf(navArgument("alertJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val alertJson = backStackEntry.arguments?.getString("alertJson") ?: ""
            val alert = try {
                Gson().fromJson(URLDecoder.decode(alertJson, "UTF-8"), WeatherAlertItem::class.java)
            } catch (e: Exception) { null }
            CityAlertDetailScreenLayout(
                alerts = if (alert != null) listOf(alert) else emptyList()
            )
        }
    }
}