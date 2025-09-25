package com.karrar.movieapp.data.remote.response.actor

import com.google.gson.annotations.SerializedName

data class CastDto(
    @SerializedName("adult")
    val adult: Boolean? = true,

    @SerializedName("gender")
    val gender: Int? = 0,

    @SerializedName("id")
    val id: Int? = 0,

    @SerializedName("known_for_department")
    val knownForDepartment: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("original_name")
    val originalName: String? = null,

    @SerializedName("popularity")
    val popularity: Double? = 0.0,

    @SerializedName("profile_path")
    val profilePath: String? = null,

    @SerializedName("cast_id")
    val castId: Int? = 0,

    @SerializedName("character")
    val character: String? = null,

    @SerializedName("credit_id")
    val creditId: String? = null,

    @SerializedName("order")
    val order: Int? = 0
)
