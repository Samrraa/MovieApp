package com.karrar.movieapp.domain.models

data class Credits(
    val cast: List<Cast> = listOf(),
    val crew: List<Crew> = listOf(),
    val id: Int = 0
)
