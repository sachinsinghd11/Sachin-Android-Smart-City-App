package me.sachinsinghdighan.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import me.sachinsinghdighan.domain.repository.wheather.WeatherAqiTrafficAlertResult
import me.sachinsinghdighan.domain.usecase.wheather.GetWeatherAirQualityAlertUseCase
import me.sachinsinghdighan.presentation.base.UiState
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherAirQualityAlertUseCase: GetWeatherAirQualityAlertUseCase
) : ViewModel() {

    private val _weatherAqiTrafficAlertState = MutableStateFlow<UiState<WeatherAqiTrafficAlertResult>>(UiState.Loading)
    val weatherAqiTrafficAlertState = _weatherAqiTrafficAlertState.asStateFlow()

    fun getWeatherAqiTrafficAlertParallel(latitude: Double, longitude: Double, location: String) {
        viewModelScope.launch {
            _weatherAqiTrafficAlertState.value = UiState.Loading
            try {
                val result = getWeatherAirQualityAlertUseCase(latitude, longitude, location)
                _weatherAqiTrafficAlertState.value = UiState.Success(result)
            } catch (e: Exception) {
                _weatherAqiTrafficAlertState.value = UiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }

    fun clearError() {
        _weatherAqiTrafficAlertState.value = UiState.Loading
    }
}