package me.sachinsinghdighan.presentation.dashboard.screen.quickstats.quickstatslayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.sachinsinghdighan.presentation.R
import me.sachinsinghdighan.presentation.commonui.TopImageWithUrl
import me.sachinsinghdighan.presentation.commonui.TopTextCenterAlign
import me.sachinsinghdighan.presentation.commonui.BottomTextCenterAlign
import me.sachinsinghdighan.presentation.commonui.TopImageWithIcon

@Composable
fun WhetherLayout(
    imageUrl: String?,
    text: String = stringResource(R.string._21_c),
    bottomText: String = stringResource(R.string.sunny),
    modifier: Modifier = Modifier,
    isTopImageVisible: Boolean = true,
    isTopTextVisible: Boolean = true,
    isTopIconVisible: Boolean = false,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.background(MaterialTheme.colorScheme.surfaceContainerLow)
    ) {
            //.clip(MaterialTheme.shapes.large)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.height(70.dp).padding(8.dp)
            ) {

                if (isTopIconVisible) {
                    TopImageWithIcon(
                        image = R.mipmap.ic_public_transport,
                        modifier = modifier.weight(1f).size(36.dp),
                        contentDescription = stringResource(R.string.sunny_day)
                    )
                }

                if (isTopImageVisible) {
                    TopImageWithUrl(
                        imageUrl = imageUrl,
                        modifier = modifier.weight(1f).size(36.dp),
                        contentDescription = stringResource(R.string.sunny_day)
                    )
                }

                if (isTopTextVisible) {
                    TopTextCenterAlign(
                        text = text,
                        modifier = modifier.weight(1f),//.padding(4.dp),
                    )
                }
            }
            BottomTextCenterAlign(
                text = bottomText,
                modifier = modifier.padding(8.dp).fillMaxWidth()
            )
        }
}

@Preview(showBackground = true)
@Composable
fun WhetherLayoutPreview() {
    WhetherLayout(
        imageUrl = "https://example.com/image.jpg",
        text = stringResource(R.string._21_c),
        bottomText = stringResource(R.string.sunny),
        isTopImageVisible = true,
        isTopTextVisible = true)
}

@Preview(showBackground = true)
@Composable
fun AQILayoutPreview() {
    WhetherLayout(
        imageUrl = "https://example.com/image.jpg",
        text = stringResource(R.string._21_c),
        bottomText = stringResource(R.string.sunny),
        isTopImageVisible = false,
        isTopTextVisible = true)
}

@Preview(showBackground = true)
@Composable
fun TrafficLayoutPreview() {
    WhetherLayout(
        imageUrl = "https://example.com/image.jpg",
        text = stringResource(R.string._21_c),
        bottomText = stringResource(R.string.sunny),
        isTopImageVisible = true,
        isTopTextVisible = false)
}