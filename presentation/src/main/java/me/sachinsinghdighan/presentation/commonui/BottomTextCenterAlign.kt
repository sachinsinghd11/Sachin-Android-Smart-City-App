package me.sachinsinghdighan.presentation.commonui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import me.sachinsinghdighan.presentation.R

@Composable
fun BottomTextCenterAlign(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelLarge,
        textAlign = TextAlign.Center,
        modifier = modifier.fillMaxWidth()//.padding(8.dp)//.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun BottomTextCenterAlignPreview() {
    BottomTextCenterAlign(stringResource(R.string.sunny))
}