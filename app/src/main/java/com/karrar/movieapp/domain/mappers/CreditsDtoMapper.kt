package com.karrar.movieapp.domain.mappers

import com.karrar.movieapp.data.remote.response.CreditsDto
import com.karrar.movieapp.domain.mappers.actor.CastDtoMapper
import com.karrar.movieapp.domain.mappers.actor.CrewDtoMapper
import com.karrar.movieapp.domain.models.Credits
import javax.inject.Inject


class CreditsDtoMapper @Inject constructor(
    private val castMapper: CastDtoMapper,
    private val crewMapper: CrewDtoMapper
) : Mapper<CreditsDto, Credits> {
    override fun map(input: CreditsDto): Credits {
        return Credits(
            id = input.id ?: 0,
            cast = input.cast?.map { castMapper.map(it) } ?: emptyList(),
            crew = input.crew?.map { crewMapper.map(it) } ?: emptyList()
        )
    }
}
