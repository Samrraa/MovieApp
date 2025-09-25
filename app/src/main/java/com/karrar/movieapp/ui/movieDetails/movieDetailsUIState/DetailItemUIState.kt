package com.karrar.movieapp.ui.movieDetails.movieDetailsUIState

import androidx.lifecycle.ViewModel
import com.karrar.movieapp.ui.models.CastUiState
import com.karrar.movieapp.ui.models.CrewGroupUiState
import com.karrar.movieapp.ui.models.MediaUiState


sealed class DetailItemUIState(val priority: Int) {

    class Header(val data: MovieDetailsUIState?) : DetailItemUIState(0)

    class Cast(val data: List<CastUiState>) : DetailItemUIState(1)

    class Crew(val data: List<CrewGroupUiState>) : DetailItemUIState(2)

    class SimilarMovies(val data: List<MediaUiState>) : DetailItemUIState(3)

    class Comment(val data: ReviewUIState) : DetailItemUIState(6)

    class Rating(val viewModel: ViewModel) : DetailItemUIState(4)

    object ReviewText : DetailItemUIState(5)

    object SeeAllReviewsButton : DetailItemUIState(7)

}
