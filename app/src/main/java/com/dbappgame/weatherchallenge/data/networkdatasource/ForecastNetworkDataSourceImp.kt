package com.dbappgame.weatherchallenge.data.networkdatasource

import com.dbappgame.weatherchallenge.domain.model.ForecastResponse
import com.dbappgame.weatherchallenge.data.networkdatasource.service.WeatherService
import javax.inject.Inject

class ForecastNetworkDataSourceImp @Inject constructor(private val service: WeatherService): ForecastNetworkDataSource {
    override suspend fun getForecast(city: String): ForecastResponse {
        return service.getForecast(city)
    }
}