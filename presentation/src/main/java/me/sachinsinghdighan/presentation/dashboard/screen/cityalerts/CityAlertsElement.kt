package me.sachinsinghdighan.presentation.dashboard.screen.cityalerts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.sachinsinghdighan.presentation.commonui.BottomTextLeftAlign
import me.sachinsinghdighan.presentation.commonui.TopTextLeftAlignStart
import me.sachinsinghdighan.presentation.commonui.AppIcon

@Composable
fun CityAlertsElement(
    modifier: Modifier = Modifier,
    topText: String = "Severe weather",
    bottomText: String = "Thunderstroms expected",
    onClick: () -> Unit = {}
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ){
        Column(modifier.weight(1f)){
            TopTextLeftAlignStart(text = topText, modifier = modifier.align(alignment = Alignment.Start).padding(start = 8.dp, top = 8.dp, end = 8.dp).fillMaxWidth())
            BottomTextLeftAlign(text = bottomText, modifier = modifier.align(alignment = Alignment.Start).padding(start = 8.dp, end = 8.dp, top = 4.dp).fillMaxWidth())
        }
        AppIcon(modifier = modifier, imageVector = Icons.Filled.KeyboardArrowRight)
    }
}

@Preview(showBackground = true)
@Composable
fun CityAlertsElementPreview() {
    CityAlertsElement(
        topText = "Severe weather",
        bottomText = "Thunderstroms expected",
        modifier = Modifier
    )
}