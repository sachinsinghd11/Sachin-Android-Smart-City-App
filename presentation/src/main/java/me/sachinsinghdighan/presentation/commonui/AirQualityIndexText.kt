package me.sachinsinghdighan.presentation.commonui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AirQualityIndexText(
    aqiText: String,
    modifier:Modifier = Modifier
) {
    Text(
        text = aqiText,
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun AirQualityIndexTextPreview(){
    AirQualityIndexText("AQI" )
}