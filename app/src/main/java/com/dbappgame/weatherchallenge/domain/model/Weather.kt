package com.dbappgame.weatherchallenge.domain.model


data class Weather (
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)