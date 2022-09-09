package com.dbappgame.weatherchallenge

fun main() {
    println(snippetChallenge())
}


fun snippetChallenge(): List<Int> {
    val list = listOf("34","43","85")
    val aux = mutableListOf<Int>()
    for (i in 0..list.size -1){
        aux.add(
            list[i].toInt()
        )
    }
    return aux
}


