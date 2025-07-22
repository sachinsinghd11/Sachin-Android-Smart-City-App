package me.sachinsinghdighan.presentation.commonui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import me.sachinsinghdighan.presentation.R

@Composable
fun SettingsIcon(modifier: Modifier = Modifier){
    IconButton (onClick = { /* settings action */ }) {
        Icon(
            imageVector = Icons.Filled.Settings,
            contentDescription = stringResource(R.string.settings_icon),
            //modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsIconPreview() {
    SettingsIcon()
}