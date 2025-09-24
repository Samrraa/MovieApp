package com.karrar.movieapp.domain.models

data class Credits(
    val cast: List<Actor> = listOf(),
    val crew: List<Crew> = listOf(),
    val id: Int = 0
)
