package com.dbappgame.weatherchallenge.domain.model

import com.google.gson.annotations.SerializedName

data class City (
    val id: Long,
    val name: String,
    @SerializedName("coord")
    val coordinate: Coord,
    val country: String,
    val population: Long,
    val timezone: Long,
    val sunrise: Long,
    val sunset: Long
)
