package com.dbappgame.weatherchallenge.data.networkdatasource.service

import com.dbappgame.weatherchallenge.domain.model.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherService {

    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String = "Mexico"
    ): ForecastResponse

}