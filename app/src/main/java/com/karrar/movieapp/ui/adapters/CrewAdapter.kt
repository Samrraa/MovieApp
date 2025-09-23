package com.karrar.movieapp.ui.adapters

import android.view.View
import com.karrar.movieapp.R
import com.karrar.movieapp.ui.base.BaseAdapter
import com.karrar.movieapp.ui.base.BaseInteractionListener
import com.karrar.movieapp.ui.models.CrewGroupUiState

class CrewAdapter(
    private val itemsList: List<CrewGroupUiState>,
    val layout: Int,
    listener: CrewInteractionListener,
) : BaseAdapter<CrewGroupUiState>(itemsList, listener) {

    override val layoutID: Int = layout

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        val divider = holder.itemView.findViewById<View>(R.id.divider)
        divider.visibility = if (position == itemsList.size - 1) View.GONE else View.VISIBLE
    }
}

interface CrewInteractionListener : BaseInteractionListener {
    fun onClickCrew(crewID: Int)
}
