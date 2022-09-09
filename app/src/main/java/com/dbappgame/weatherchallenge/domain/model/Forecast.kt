package com.dbappgame.weatherchallenge.domain.model

import com.google.gson.annotations.SerializedName

data class Forecast(
    val dt: Long,
    @SerializedName("main")
    val main: MainInfo,
    val weather: List<Weather>,
    val clouds: Clouds,
    val wind: Wind,
    val visibility: Long,
    val pop: Double,
    @SerializedName("rain")
    val rain: Rain? = null,
    val sys: Sys,
    @SerializedName("dt_txt")
    val dtTxt: String
)