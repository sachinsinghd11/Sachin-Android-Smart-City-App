package me.sachinsinghdighan.presentation.dashboard.screen.cityalerts

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.sachinsinghdighan.domain.model.wheather.WeatherAlertItem
import me.sachinsinghdighan.presentation.commonui.QuickStatsText
import me.sachinsinghdighan.presentation.commonui.TopTextCenterAlign

@Composable
fun CityAlertLayout(
    alertsData: List<WeatherAlertItem> = emptyList(),
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    onAlertClick: (WeatherAlertItem) -> Unit = {}
){
    Column(modifier = modifier.padding(8.dp)) {
        QuickStatsText(text = "City Alerts",modifier = modifier.padding(start = 8.dp, end = 8.dp))
       if(alertsData.isEmpty()){
           TopTextCenterAlign("No Alerts Found", modifier = modifier.padding(8.dp))
       }else{
           LazyColumn {
               items(alertsData.size) { index ->
                   val alert = alertsData[index]
                   CityAlertsElement(
                       topText = alert.event?:"--",
                       bottomText = alert.headline?:"--",
                       modifier = modifier,
                       onClick = { onAlertClick(alert) }
                   )
               }
           }
       }

    }
}

@Preview(showBackground = true)
@Composable
fun CityAlertLayoutPreview() {
    CityAlertLayout(modifier = Modifier)
}


