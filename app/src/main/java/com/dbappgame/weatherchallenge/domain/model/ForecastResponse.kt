package com.dbappgame.weatherchallenge.domain.model

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    val cod: String,
    val message: Int,
    val cnt: Int,
    @SerializedName("list")
    val list: List<Forecast>
)