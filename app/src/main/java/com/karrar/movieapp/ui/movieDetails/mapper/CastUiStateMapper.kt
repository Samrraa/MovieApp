package com.karrar.movieapp.ui.movieDetails.mapper

import com.karrar.movieapp.domain.mappers.Mapper
import com.karrar.movieapp.domain.models.Cast
import com.karrar.movieapp.ui.models.CastUiState
import javax.inject.Inject

class CastUiStateMapper @Inject constructor() : Mapper<Cast, CastUiState> {
    override fun map(input: Cast): CastUiState {
        return CastUiState(
            id = input.id,
            imageUrl = input.profilePath,
            name = input.name,
            character = input.character
        )
    }
}
