package com.dbappgame.weatherchallenge.data.repository

import com.dbappgame.weatherchallenge.domain.model.ForecastResponse

interface ForecastRepository {
    suspend fun getForecast(city: String): ForecastResponse
}