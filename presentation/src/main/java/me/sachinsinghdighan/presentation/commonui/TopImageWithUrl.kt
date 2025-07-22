package me.sachinsinghdighan.presentation.commonui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.sachinsinghdighan.presentation.R

@Composable
fun TopImageWithUrl(
    imageUrl: String? = "", @SuppressLint("ModifierParameter") modifier: Modifier = Modifier, contentDescription: String? = null
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier,
        placeholder = painterResource(id = R.drawable.ic_launcher_background),
        error = painterResource(id = R.drawable.ic_launcher_background),
        contentScale = ContentScale.Crop,

    )
}

@Preview(showBackground = true)
@Composable
fun TopImagePreview() {
    TopImageWithUrl(imageUrl = "https://example.com/image.jpg",
        contentDescription = stringResource(R.string.sunny_day),
        modifier = Modifier.size(48.dp))
}