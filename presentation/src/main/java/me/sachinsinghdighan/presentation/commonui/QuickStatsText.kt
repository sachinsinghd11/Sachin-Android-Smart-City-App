package me.sachinsinghdighan.presentation.commonui

import android.annotation.SuppressLint
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
fun QuickStatsText(text: String = "Quick Stats", @SuppressLint("ModifierParameter") modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        modifier = modifier//.padding(start = 12.dp)

    )
}

@Preview(showBackground = true)
@Composable
fun QuickStatsPreview() {
    QuickStatsText("Quick Stats")
}