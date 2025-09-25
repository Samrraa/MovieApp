package com.karrar.movieapp.ui.tvShowDetails.tvShowUIState

import androidx.lifecycle.ViewModel
import com.karrar.movieapp.ui.models.CastUiState
import com.karrar.movieapp.ui.models.CrewGroupUiState

sealed class DetailItemUIState(val priority: Int) {

    class Header(val data: TvShowDetailsResultUIState) : DetailItemUIState(0)

    class Cast(val data: List<CastUiState>) : DetailItemUIState(1)

    class Crew(val data: List<CrewGroupUiState>) : DetailItemUIState(2)

    class Seasons(val data: List<SeasonUIState>) : DetailItemUIState(3)

    class Rating(val viewModel: ViewModel) : DetailItemUIState(4)

    object ReviewText : DetailItemUIState(5)

    class Comment(val data: ReviewUIState) : DetailItemUIState(6)

    object SeeAllReviewsButton : DetailItemUIState(7)
}
