package me.sachinsinghdighan.presentation.commonui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import me.sachinsinghdighan.presentation.R

@Composable
fun TopTextLeftAlign(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight.Bold,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun TopTextLeftAlignPreview() {
    TopTextLeftAlign(stringResource(R.string._21_c))
}