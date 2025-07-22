package me.sachinsinghdighan.presentation.commonui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import me.sachinsinghdighan.presentation.R

@Composable
fun AppBarTitleText(modifier: Modifier = Modifier){
    Text(
        text = stringResource(R.string.smart_city_hub),
        modifier = modifier.fillMaxWidth(),
        style = MaterialTheme.typography.titleLarge,
fontWeight = FontWeight.Bold
        )
}

@Preview(showBackground = true)
@Composable
fun AppTitleTextPreview(){
    AppBarTitleText()
}
