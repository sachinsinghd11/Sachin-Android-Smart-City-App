package me.sachinsinghdighan.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.sachinsinghdighan.data.remote.api.AirQualityApi
import me.sachinsinghdighan.data.remote.api.TrafficApi
import me.sachinsinghdighan.data.remote.api.WeatherApi
import me.sachinsinghdighan.data.remote.api.WeatherAlertApi
import me.sachinsinghdighan.domain.repository.wheather.WeatherRepository
import me.sachinsinghdighan.domain.usecase.wheather.GetWeatherAirQualityAlertUseCase
import me.sachinsinghdighan.utils.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    @WeatherRetrofit
    fun provideWeatherRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @AirQualityRetrofit
    fun provideAirQualityRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.AQI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @WeatherRetrofit
    fun provideWeatherApi(@WeatherRetrofit retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    @AirQualityRetrofit
    fun provideAirQualityApi(@AirQualityRetrofit retrofit: Retrofit): AirQualityApi {
        return retrofit.create(AirQualityApi::class.java)
    }

    @Provides
    @Singleton
    @TrafficFlowRetrofit
    fun provideTrafficRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.TRAFFIC_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @TrafficFlowRetrofit
    fun provideTrafficApi(@TrafficFlowRetrofit trafficRetrofit: Retrofit): TrafficApi {
        return trafficRetrofit.create(TrafficApi::class.java)
    }

    @Provides
    @Singleton
    @WeatherAlertRetrofit
    fun provideWeatherAlertRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.WEATHERAPI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherAlertApi(@WeatherAlertRetrofit retrofit: Retrofit): WeatherAlertApi {
        return retrofit.create(WeatherAlertApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGetWeatherAirQualityAlertUseCase(
        weatherRepository: WeatherRepository
    ): GetWeatherAirQualityAlertUseCase {
        return GetWeatherAirQualityAlertUseCase(weatherRepository)
    }
}