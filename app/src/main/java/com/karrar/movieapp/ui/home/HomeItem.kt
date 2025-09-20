package com.karrar.movieapp.ui.home

import com.karrar.movieapp.ui.home.homeUiState.PopularUiState
import com.karrar.movieapp.ui.models.CollectionUiState
import com.karrar.movieapp.ui.models.MediaUi

sealed class HomeItem(val priority: Int) {
    data class Slider(val items: List<PopularUiState>) : HomeItem(0)
    data class RecentlyReleased(val items: List<MediaUi>) : HomeItem(1)
    data class ItemSuggestion(
        val mainTitle: String,
        val secondaryTitle: String,
        val infoTitle: String
    ) : HomeItem(2)

    data class UpcomingMovies(val items: List<MediaUi>) : HomeItem(3)
    data class MatchesYourVibe(val items: List<MediaUi>) : HomeItem(4)
    data class TopRatedTVShows(val items: List<MediaUi>) : HomeItem(5)
    data class RecentlyViewed(val items: List<MediaUi>) : HomeItem(6)
    data class Collections(val items: List<CollectionUiState>) : HomeItem(8)
}