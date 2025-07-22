package me.sachinsinghdighan.data.mapper.wheather

import me.sachinsinghdighan.data.remote.wheatherdto.CurrentWeatherResponseDto
import me.sachinsinghdighan.domain.model.wheather.CurrentWeatherData
import me.sachinsinghdighan.domain.model.wheather.Coord
import me.sachinsinghdighan.domain.model.wheather.Weather
import me.sachinsinghdighan.domain.model.wheather.Main
import me.sachinsinghdighan.domain.model.wheather.Wind
import me.sachinsinghdighan.domain.model.wheather.Clouds
import me.sachinsinghdighan.domain.model.wheather.Sys
import me.sachinsinghdighan.data.remote.wheatherdto.AQIDataDto
import me.sachinsinghdighan.domain.model.wheather.AQIData
import me.sachinsinghdighan.domain.model.wheather.AQIDataDetails
import me.sachinsinghdighan.domain.model.wheather.AQILocation
import me.sachinsinghdighan.domain.model.wheather.AQICurrent
import me.sachinsinghdighan.domain.model.wheather.AQIPollution
import me.sachinsinghdighan.domain.model.wheather.AQIWeather
import me.sachinsinghdighan.data.remote.wheatherdto.TrafficFlowDto
import me.sachinsinghdighan.domain.model.wheather.TrafficFlow
import me.sachinsinghdighan.domain.model.wheather.FlowSegmentData
import me.sachinsinghdighan.domain.model.wheather.Coordinates
import me.sachinsinghdighan.domain.model.wheather.Coordinate
import me.sachinsinghdighan.data.remote.wheatherdto.WeatherAlertResponseDto
import me.sachinsinghdighan.domain.model.wheather.WeatherAlertResponse
import me.sachinsinghdighan.domain.model.wheather.WeatherAlertLocation
import me.sachinsinghdighan.domain.model.wheather.WeatherAlertItem
import me.sachinsinghdighan.domain.model.wheather.WeatherAlerts

fun CurrentWeatherResponseDto.toDomainModel(): CurrentWeatherData {
    return CurrentWeatherData(
        coord = Coord(
            lon = this.coord.lon,
            lat = this.coord.lat
        ),
        weather = this.weather.map {
            Weather(
                id = it.id,
                main = it.main,
                description = it.description,
                icon = it.icon
            )
        },
        base = this.base,
        main = Main(
            temp = this.main.temp,
            feelsLike = this.main.feelsLike,
            tempMin = this.main.tempMin,
            tempMax = this.main.tempMax,
            pressure = this.main.pressure,
            humidity = this.main.humidity,
            seaLevel = this.main.seaLevel,
            grndLevel = this.main.grndLevel
        ),
        visibility = this.visibility,
        wind = Wind(
            speed = this.wind.speed,
            deg = this.wind.deg
        ),
        clouds = Clouds(
            all = this.clouds.all
        ),
        dt = this.dt,
        sys = Sys(
            type = this.sys.type,
            id = this.sys.id,
            country = this.sys.country,
            sunrise = this.sys.sunrise,
            sunset = this.sys.sunset
        ),
        timezone = this.timezone,
        id = this.id,
        name = this.name,
        cod = this.cod
    )
}

fun AQIDataDto.toDomainModel(): AQIData {
    return AQIData(
        status = this.status,
        data = AQIDataDetails(
            city = this.data.city,
            state = this.data.state,
            country = this.data.country,
            location = AQILocation(
                type = this.data.location.type,
                coordinates = this.data.location.coordinates
            ),
            current = AQICurrent(
                pollution = AQIPollution(
                    ts = this.data.current.pollution.ts,
                    aqius = this.data.current.pollution.aqius,
                    mainus = this.data.current.pollution.mainus,
                    aqicn = this.data.current.pollution.aqicn,
                    maincn = this.data.current.pollution.maincn
                ),
                weather = AQIWeather(
                    ts = this.data.current.weather.ts,
                    ic = this.data.current.weather.ic,
                    hu = this.data.current.weather.hu,
                    pr = this.data.current.weather.pr,
                    tp = this.data.current.weather.tp,
                    wd = this.data.current.weather.wd,
                    ws = this.data.current.weather.ws
                )
            )
        )
    )
}

fun TrafficFlowDto.toDomainModel(): TrafficFlow {
    return TrafficFlow(
        flowSegmentData = FlowSegmentData(
            frc = this.flowSegmentData.frc,
            currentSpeed = this.flowSegmentData.currentSpeed,
            freeFlowSpeed = this.flowSegmentData.freeFlowSpeed,
            currentTravelTime = this.flowSegmentData.currentTravelTime,
            freeFlowTravelTime = this.flowSegmentData.freeFlowTravelTime,
            confidence = this.flowSegmentData.confidence,
            roadClosure = this.flowSegmentData.roadClosure,
            coordinates = this.flowSegmentData.coordinates?.let { coords ->
                Coordinates(
                    coordinate = coords.coordinate.map {
                        Coordinate(latitude = it.latitude, longitude = it.longitude)
                    }
                )
            },
            version = this.flowSegmentData.version
        )
    )
}

fun WeatherAlertResponseDto.toDomainModel(): WeatherAlertResponse {
    return WeatherAlertResponse(
        location = this.location?.let {
            WeatherAlertLocation(
                name = it.name,
                region = it.region,
                country = it.country,
                lat = it.lat,
                lon = it.lon,
                tzId = it.tzId,
                localtimeEpoch = it.localtimeEpoch,
                localtime = it.localtime
            )
        },
        alerts = this.alerts?.let { alertsDto ->
            WeatherAlerts(
                alert = alertsDto.alert?.map { alertDto ->
                    WeatherAlertItem(
                        headline = alertDto.headline,
                        msgType = alertDto.msgType,
                        severity = alertDto.severity,
                        urgency = alertDto.urgency,
                        areas = alertDto.areas,
                        category = alertDto.category,
                        certainty = alertDto.certainty,
                        event = alertDto.event,
                        note = alertDto.note,
                        effective = alertDto.effective,
                        expires = alertDto.expires,
                        desc = alertDto.desc,
                        instruction = alertDto.instruction
                    )
                }
            )
        }
    )
}