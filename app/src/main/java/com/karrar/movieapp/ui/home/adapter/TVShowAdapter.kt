package com.karrar.movieapp.ui.home.adapter

import com.karrar.movieapp.R
import com.karrar.movieapp.domain.enums.AllMediaType
import com.karrar.movieapp.domain.models.Media
import com.karrar.movieapp.ui.base.BaseAdapter
import com.karrar.movieapp.ui.base.BaseInteractionListener
import com.karrar.movieapp.ui.models.MediaUi

class TVShowAdapter(items: List<MediaUi>,val listener: TVShowInteractionListener) :
    BaseAdapter<MediaUi>(items, listener) {
    override val layoutID: Int = R.layout.item_tvshow
}

interface TVShowInteractionListener : BaseInteractionListener {
    fun onClickTVShow(tVShowID: Int)
    fun onClickSeeTVShow(type: AllMediaType)
}

