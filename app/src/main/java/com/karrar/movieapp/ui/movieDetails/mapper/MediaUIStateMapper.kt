package com.karrar.movieapp.ui.movieDetails.mapper

import com.karrar.movieapp.domain.mappers.Mapper
import com.karrar.movieapp.domain.models.Media
import com.karrar.movieapp.ui.models.MediaUi
import javax.inject.Inject

class MediaUIStateMapper @Inject constructor() : Mapper<Media, MediaUi> {
    override fun map(input: Media): MediaUi {
        return MediaUi(
            id = input.mediaID,
            imageUrl = input.mediaImage,
        )
    }
}