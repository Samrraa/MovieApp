package com.karrar.movieapp.ui.home.homeUiState

import com.karrar.movieapp.ui.home.HomeItem
import com.karrar.movieapp.ui.models.CollectionUiState

data class HomeUiState(
    val popularMovies: HomeItem = HomeItem.Slider(emptyList()),
    val recentlyReleased: HomeItem = HomeItem.RecentlyReleased(emptyList()),
    val whatShouldIWatch: HomeItem = HomeItem.WhatShouldIWatch("", "", ""),
    val needMoreWatch: HomeItem = HomeItem.NeedMoreWatch("", "", ""),
    val upcomingMovies: HomeItem = HomeItem.UpcomingMovies(emptyList()),
    val matchesYourVibe: HomeItem = HomeItem.MatchesYourVibe(emptyList()),
    val topRatedTVShows: HomeItem = HomeItem.TopRatedTVShows(emptyList()),
    val recentlyViewed: HomeItem = HomeItem.RecentlyViewed(emptyList()),
    val collections: HomeItem = HomeItem.Collections(
        listOf(
            CollectionUiState(0, "My Favorite TV Shows", "5 shows"),
            CollectionUiState(0, "My Favorite TV Shows", "5 shows"),
            CollectionUiState(0, "My Favorite TV Shows", "5 shows"),
            CollectionUiState(0, "My Favorite TV Shows", "5 shows"),
            CollectionUiState(0, "My Favorite TV Shows", "5 shows"),
            CollectionUiState(0, "My Favorite TV Shows", "5 shows"),
            CollectionUiState(0, "My Favorite TV Shows", "5 shows"),
        )
    ),
    val isLoading: Boolean = false,
    val error: List<String> = emptyList(),
)