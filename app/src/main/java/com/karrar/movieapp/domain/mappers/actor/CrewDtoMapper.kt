package com.karrar.movieapp.domain.mappers.actor

import com.karrar.movieapp.data.remote.response.CrewDto
import com.karrar.movieapp.domain.mappers.Mapper
import com.karrar.movieapp.domain.models.Crew
import javax.inject.Inject

class CrewDtoMapper @Inject constructor() : Mapper<CrewDto, Crew> {
    override fun map(input: CrewDto): Crew {
        return Crew(
            crewID = input.id,
            crewName = input.name ?: "Unknown",
            crewJob = input.job ?: "Unknown"
        )
    }
}
