package me.sachinsinghdighan.presentation.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
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
import java.net.URLEncoder
import me.sachinsinghdighan.domain.repository.wheather.WeatherAqiTrafficAlertResult
import me.sachinsinghdighan.presentation.R
import me.sachinsinghdighan.presentation.base.UiState
import me.sachinsinghdighan.presentation.base.Route
import me.sachinsinghdighan.presentation.dashboard.screen.DashBoardScreenLayout
import me.sachinsinghdighan.presentation.dashboard.screen.apptitlebar.SmartCityAppTitleBar
import me.sachinsinghdighan.presentation.dashboard.screen.cityalerts.CityAlertLayout
import me.sachinsinghdighan.presentation.dashboard.screen.miscellaneousservice.Miscellaneous
import me.sachinsinghdighan.presentation.dashboard.screen.miscellaneousservice.MiscellaneousLayout
import me.sachinsinghdighan.presentation.dashboard.screen.quickstats.quickstatslayout.QuickStatsWithTitleLayout

@Composable
fun DashboardScreenRoute(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        DashBoardScreenLayout(navController = navController, innerPadding = innerPadding)
    }
}



