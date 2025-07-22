package me.sachinsinghdighan.presentation.dashboard.screen.miscellaneousservice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.sachinsinghdighan.presentation.R
import me.sachinsinghdighan.presentation.commonui.MiscellaneousElement

data class Miscellaneous(val image: Int, val title: String)

@Composable
fun MiscellaneousLayout(
    miscellaneous: List<Miscellaneous>,
    modifier: Modifier = Modifier
) {



    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 8.dp),
        modifier = modifier
            .background(MaterialTheme.colorScheme.surfaceContainerLow)
            .padding(top = 8.dp, bottom = 8.dp)//.height(120.dp)
    ) {
        items(miscellaneous) { item ->
            MiscellaneousElement(item, modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MiscellaneousLayoutPreview() {
    val miscellaneousList = listOf(
        Miscellaneous(image = R.mipmap.ic_public_transport, title = "Public Transport"),
        Miscellaneous(image = R.mipmap.ic_plus_sign, title = "Emergency Services"),
        Miscellaneous(image = R.mipmap.ic_bin, title = "Waste Management"),
        Miscellaneous(image = R.mipmap.ic_calendar, title = "City\n Events"),
    )
    MiscellaneousLayout(miscellaneousList)
}