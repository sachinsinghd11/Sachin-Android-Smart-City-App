package me.sachinsinghdighan.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import me.sachinsinghdighan.presentation.base.SmartCityNavHost
import me.sachinsinghdighan.presentation.theme.SachinAndroidSmartCityAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SachinAndroidSmartCityAppTheme {
                SmartCityNavHost()
            }
        }
    }
}

