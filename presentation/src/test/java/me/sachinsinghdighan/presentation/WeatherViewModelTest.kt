package me.sachinsinghdighan.presentation

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import me.sachinsinghdighan.domain.repository.wheather.WeatherAqiTrafficAlertResult
import me.sachinsinghdighan.domain.usecase.wheather.GetWeatherAirQualityAlertUseCase
import me.sachinsinghdighan.presentation.base.UiState
import me.sachinsinghdighan.presentation.dashboard.WeatherViewModel
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class WeatherViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var useCase: GetWeatherAirQualityAlertUseCase
    private lateinit var viewModel: WeatherViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        useCase = mockk()
        viewModel = WeatherViewModel(getWeatherAirQualityAlertUseCase = useCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getWeatherAqiTrafficAlertParallel emits Success when usecase returns data`() = runTest(testDispatcher) {
        val fakeResult = WeatherAqiTrafficAlertResult(null, null, null, null)
        coEvery { useCase.invoke(any(), any(), any()) } returns fakeResult

        viewModel.getWeatherAqiTrafficAlertParallel(1.0, 2.0, "TestCity")

        viewModel.weatherAqiTrafficAlertState.test {
            assertEquals(UiState.Loading, awaitItem())
            val success = awaitItem()
            assert(success is UiState.Success && success.data == fakeResult)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `getWeatherAqiTrafficAlertParallel emits Error when usecase throws`() = runTest(testDispatcher) {
        coEvery { useCase.invoke(any(), any(), any()) } throws RuntimeException("API error")

        viewModel.getWeatherAqiTrafficAlertParallel(1.0, 2.0, "TestCity")

        viewModel.weatherAqiTrafficAlertState.test {
            assertEquals(UiState.Loading, awaitItem())
            val error = awaitItem()
            assert(error is UiState.Error && error.message.contains("API error"))
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `clearError resets state to Loading`() = runTest(testDispatcher) {
        viewModel.clearError()
        viewModel.weatherAqiTrafficAlertState.test {
            assertEquals(UiState.Loading, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }
} 