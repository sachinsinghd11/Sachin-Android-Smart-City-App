package me.sachinsinghdighan.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WeatherRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AirQualityRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TrafficFlowRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WeatherAlertRetrofit