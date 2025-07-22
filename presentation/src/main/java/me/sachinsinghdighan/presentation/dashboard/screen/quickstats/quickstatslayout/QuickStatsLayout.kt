package me.sachinsinghdighan.presentation.dashboard.screen.quickstats.quickstatslayout

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.sachinsinghdighan.presentation.R

@Composable
fun QuickStatsLayout(
    imageUrl: String? = "--",
    condition: String = "--",
    temperature: String = "--",
    aqiData: String= "--",
    aqiCondition: String = "--",
    trafficStatus: String = "--",
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier){
    // Implement composable here
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.height(140.dp).fillMaxWidth().padding(8.dp)


    ) {
        WhetherLayout(
            imageUrl = imageUrl,
            text = temperature,
            bottomText = condition,
            modifier = modifier.weight(1f).padding(4.dp),
            isTopImageVisible = true,
            isTopTextVisible = true
        )
        WhetherLayout(
            imageUrl = imageUrl,
            text = aqiData,
            bottomText = aqiCondition,
            modifier = modifier.weight(1f).padding(4.dp),
            isTopImageVisible = false, isTopTextVisible = true)
        WhetherLayout(
            imageUrl = imageUrl,
            text = stringResource(R.string._21_c),
            bottomText = trafficStatus,
            modifier = modifier.weight(1f).padding(4.dp),
            isTopImageVisible = false,
            isTopTextVisible = false,
            isTopIconVisible = true)

    }
}

@Preview(showBackground = true)
@Composable
fun QuickStatsLayoutPreview(){
    QuickStatsLayout(
        imageUrl = "https://openweathermap.org/img/wn/01d@2x.png",
    condition = "Sunny",
    temperature = "30 C",)
}