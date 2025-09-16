package com.karrar.movieapp.ui.mappers


import com.karrar.movieapp.domain.mappers.Mapper
import com.karrar.movieapp.domain.models.Media
import com.karrar.movieapp.ui.models.MediaUi
import javax.inject.Inject

class MediaUiMapper @Inject constructor() : Mapper<Media, MediaUi> {
    override fun map(input: Media): MediaUi {
        return MediaUi(
            id= input.mediaID,
            title = input.mediaName,
            imageUrl = input.mediaImage,
            rate = input.mediaRate.toString()
        )
    }
}