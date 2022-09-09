package com.dbappgame.weatherchallenge.domain.model

import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("3h")
    val threeH: Double
) {

}
