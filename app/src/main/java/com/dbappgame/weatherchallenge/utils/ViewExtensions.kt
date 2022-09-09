package com.dbappgame.weatherchallenge.utils

import android.view.View


fun View.showView(show: Boolean = false){
    this.visibility = if (show) View.VISIBLE else View.GONE
}