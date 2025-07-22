package me.sachinsinghdighan.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.sachinsinghdighan.data.remote.api.AirQualityApi
import me.sachinsinghdighan.data.remote.api.TrafficApi
import me.sachinsinghdighan.data.remote.api.WeatherAlertApi
import me.sachinsinghdighan.data.remote.api.WeatherApi
import me.sachinsinghdighan.data.repository.WeatherRepositoryImpl
import me.sachinsinghdighan.domain.repository.wheather.WeatherRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(
        @WeatherRetrofit weatherApi: WeatherApi,
        @AirQualityRetrofit airQualityApi: AirQualityApi,
        @TrafficFlowRetrofit trafficApi: TrafficApi,
        weatherAlertApi: WeatherAlertApi
    ): WeatherRepository = WeatherRepositoryImpl(weatherApi, airQualityApi, trafficApi, weatherAlertApi)


}