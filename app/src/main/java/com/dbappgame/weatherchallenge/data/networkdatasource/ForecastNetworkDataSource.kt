package com.dbappgame.weatherchallenge.data.networkdatasource

import com.dbappgame.weatherchallenge.domain.model.ForecastResponse

interface ForecastNetworkDataSource {
    suspend fun getForecast(city: String): ForecastResponse
}