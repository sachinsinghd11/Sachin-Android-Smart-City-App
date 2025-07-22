package me.sachinsinghdighan.presentation.commonui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.sachinsinghdighan.presentation.R

@Composable
fun TopImageWithIcon(
    image: Int, modifier: Modifier = Modifier, contentDescription: String? = null
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = contentDescription,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun TopImageWithIconPreview() {
    TopImageWithIcon(
        R.drawable.ic_launcher_background,
        contentDescription = stringResource(R.string.sunny_day),
        modifier = Modifier.size(48.dp))
}