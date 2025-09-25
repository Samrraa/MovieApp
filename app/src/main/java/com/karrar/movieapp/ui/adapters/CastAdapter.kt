package com.karrar.movieapp.ui.adapters

import com.karrar.movieapp.ui.base.BaseAdapter
import com.karrar.movieapp.ui.models.CastUiState

class CastAdapter(
    items: List<CastUiState>,
    val layout: Int,
    val listener: ActorsInteractionListener
) :
    BaseAdapter<CastUiState>(items, listener) {
    override val layoutID: Int = layout
}
