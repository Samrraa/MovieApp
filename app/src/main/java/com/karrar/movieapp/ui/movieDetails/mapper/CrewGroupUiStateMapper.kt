package com.karrar.movieapp.ui.movieDetails.mapper

import com.karrar.movieapp.domain.models.Crew
import com.karrar.movieapp.ui.models.CrewGroupUiState
import javax.inject.Inject

class CrewGroupUiStateMapper @Inject constructor() {

    fun map(crews: List<Crew>, limit: Int = 10): List<CrewGroupUiState> {
        return crews
            .groupBy { it.crewJob }
            .map { (job, crewList) ->
                CrewGroupUiState(
                    job = job,
                    names = crewList.joinToString(", ") { it.crewName }
                )
            }.take(limit)
    }
}
