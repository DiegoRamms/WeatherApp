package com.dbappgame.weatherchallenge.data.repository

import com.dbappgame.weatherchallenge.domain.model.ForecastResponse
import com.dbappgame.weatherchallenge.data.networkdatasource.ForecastNetworkDataSource
import javax.inject.Inject

class ForecastRepositoryImp @Inject constructor(
    private val networkDataSource: ForecastNetworkDataSource
) : ForecastRepository {
    override suspend fun getForecast(city: String): ForecastResponse {
        return networkDataSource.getForecast(city)
    }
}