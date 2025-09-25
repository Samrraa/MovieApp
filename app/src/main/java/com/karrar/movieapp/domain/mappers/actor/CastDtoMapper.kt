package com.karrar.movieapp.domain.mappers.actor

import com.karrar.movieapp.BuildConfig
import com.karrar.movieapp.data.remote.response.actor.CastDto
import com.karrar.movieapp.domain.mappers.Mapper
import com.karrar.movieapp.domain.models.Cast
import javax.inject.Inject

class CastDtoMapper @Inject constructor() : Mapper<CastDto, Cast> {
    override fun map(input: CastDto): Cast {
        return Cast(
            id = input.id ?: 0,
            name = input.name ?: "unknown",
            character = input.character ?: "unknown",
            profilePath = BuildConfig.IMAGE_BASE_PATH + input.profilePath
        )
    }
}
