package com.karrar.movieapp.data.remote.response


import com.google.gson.annotations.SerializedName
import com.karrar.movieapp.data.remote.response.actor.CastDto

data class CreditsDto(
    @SerializedName("cast")
    val cast: List<CastDto>? = listOf(),
    @SerializedName("crew")
    val crew: List<CrewDto>? = listOf(),
    @SerializedName("id")
    val id: Int? = 0
)
