package me.sachinsinghdighan.presentation.commonui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import me.sachinsinghdighan.presentation.R

@Composable
fun AppIcon(modifier: Modifier = Modifier, imageVector: ImageVector = Icons.Filled.Info){
    IconButton (onClick = { /* settings action */ }) {
        Icon(
            imageVector = imageVector,
            contentDescription = stringResource(R.string.information)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppIconIconPreview() {
    AppIcon()
}