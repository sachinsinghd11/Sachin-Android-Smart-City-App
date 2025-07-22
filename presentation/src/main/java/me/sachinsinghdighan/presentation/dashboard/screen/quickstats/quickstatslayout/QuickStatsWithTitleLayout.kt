package me.sachinsinghdighan.presentation.dashboard.screen.quickstats.quickstatslayout

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.widget.Toast
import me.sachinsinghdighan.presentation.commonui.QuickStatsText

@Composable
fun QuickStatsWithTitleLayout(
    imageUrl: String? = "",
    condition: String = "--",
    temperature: String = "--",
    aqiData: String= "--",
    aqiCondition: String = "--",
    trafficStatus: String = "--",
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .clickable {
                onClick?.invoke() ?: Toast.makeText(context, "QuickStats clicked!", Toast.LENGTH_SHORT).show()
            }
    ) {
        QuickStatsText(modifier = modifier.padding(start = 12.dp))
        QuickStatsLayout(
            imageUrl = imageUrl,
            condition = condition,
            temperature = temperature,
            aqiData = aqiData,
            aqiCondition = aqiCondition,
            trafficStatus = trafficStatus,
            modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun QuickStatsWithTitleLayoutPreview(){
    QuickStatsWithTitleLayout(condition = "Sunny", temperature = "20°C")
}
