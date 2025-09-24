package com.karrar.movieapp.domain.usecases.movieDetails

import com.karrar.movieapp.data.repository.MovieRepository
import com.karrar.movieapp.domain.enums.MediaType
import com.karrar.movieapp.domain.mappers.CreditsDtoMapper
import com.karrar.movieapp.domain.mappers.movie.MovieDetailsMapper
import com.karrar.movieapp.domain.mappers.movie.MovieMapper
import com.karrar.movieapp.domain.models.Credits
import com.karrar.movieapp.domain.models.Media
import com.karrar.movieapp.domain.models.MediaDetailsReviews
import com.karrar.movieapp.domain.models.MovieDetails
import com.karrar.movieapp.domain.usecases.GetReviewsUseCase
import com.karrar.movieapp.utilities.Constants.MAX_NUM_REVIEWS
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieDetailsMapper: MovieDetailsMapper,
    private val getMovieReviewsUseCase: GetReviewsUseCase,
    private val movieMapper: MovieMapper,
    private val creditsDtoMapper: CreditsDtoMapper
) {
    suspend fun getMovieDetails(movieId: Int): MovieDetails {
        val response = movieRepository.getMovieDetails(movieId)
        return response?.let {
            movieDetailsMapper.map(response)
        } ?: throw Throwable("Not Success")
    }

    suspend fun getMovieCredits(movieId: Int): Credits {
        return movieRepository.getMovieCredits(movieId)?.let {
            creditsDtoMapper.map(it)
        } ?: throw Throwable("Not Success")
    }

    suspend fun getMovieReviews(movieId: Int): MediaDetailsReviews {
        val reviews = getMovieReviewsUseCase(MediaType.MOVIE, movieId)
        return MediaDetailsReviews(reviews.take(MAX_NUM_REVIEWS), reviews.size > MAX_NUM_REVIEWS)
    }

    suspend fun getSimilarMovie(movieId: Int): List<Media> {
        return movieRepository.getSimilarMovie(movieId)?.let {
            it.map { movieMapper.map(it) }
        } ?: throw Throwable("Not Success")
    }
}