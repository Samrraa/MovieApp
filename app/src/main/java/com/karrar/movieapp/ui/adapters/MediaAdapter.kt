package com.karrar.movieapp.ui.adapters

import com.karrar.movieapp.R
import com.karrar.movieapp.ui.base.BaseAdapter
import com.karrar.movieapp.ui.base.BaseInteractionListener
import com.karrar.movieapp.ui.models.MediaUi

class MediaAdapter(items: List<MediaUi>, listener: MediaInteractionListener,val title:String) :
    BaseAdapter<MediaUi>(items, listener) {
    override val layoutID: Int = R.layout.item_media_card
}

interface MediaInteractionListener : BaseInteractionListener {
    fun onClickMedia(mediaId: Int)
}