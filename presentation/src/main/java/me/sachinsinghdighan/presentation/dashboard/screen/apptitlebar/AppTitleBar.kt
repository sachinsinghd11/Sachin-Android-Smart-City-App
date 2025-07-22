package me.sachinsinghdighan.presentation.dashboard.screen.apptitlebar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.sachinsinghdighan.presentation.commonui.AppBarTitleText
import me.sachinsinghdighan.presentation.commonui.AppIcon
import me.sachinsinghdighan.presentation.commonui.SettingsIcon

@Composable
fun SmartCityAppTitleBar(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding( start = 16.dp, top = 16.dp, bottom = 16.dp
            )
    ) {
        AppBarTitleText(modifier = Modifier.weight(1f))
        AppIcon(modifier, Icons.Filled.Settings)
        AppIcon(modifier, Icons.Filled.Info)
    }
}

@Preview(showBackground = true)
@Composable
fun SmartCityAppTitleBarPreview() {
    SmartCityAppTitleBar()
}

