package me.sachinsinghdighan.presentation.commonui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.sachinsinghdighan.presentation.R
import me.sachinsinghdighan.presentation.dashboard.screen.miscellaneousservice.Miscellaneous

@Composable
fun MiscellaneousElement(
    miscellaneous: Miscellaneous,
    modifier: Modifier = Modifier,
) {

    Row(
        modifier = modifier
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.surfaceBright),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TopImageWithIcon(image = miscellaneous.image, contentDescription = miscellaneous.title, modifier = modifier.size(46.dp))
        TopTextLeftAlignStart(text = miscellaneous.title, modifier = modifier.padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MiscellaneousElementPreview() {
        val cellaneousList = Miscellaneous(image = R.mipmap.ic_public_transport, title = "Element 1")

    MiscellaneousElement(
        cellaneousList,
        modifier = Modifier
    )
}