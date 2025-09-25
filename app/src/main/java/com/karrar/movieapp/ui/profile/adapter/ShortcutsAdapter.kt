package com.karrar.movieapp.ui.profile.adapter

import com.karrar.movieapp.R
import com.karrar.movieapp.ui.base.BaseAdapter
import com.karrar.movieapp.ui.base.BaseInteractionListener

class ShortcutsAdapter(
    items: List<Shortcut> = Shortcut.entries, listener: ShortcutsInteractionListener,
    override val layoutID: Int = R.layout.item_shortcut
) : BaseAdapter<Shortcut>(items, listener)

interface ShortcutsInteractionListener : BaseInteractionListener {
    fun onShortcutClick(shortcut: Shortcut)
}

enum class Shortcut(val titleRes: Int, val iconRes: Int) {
    HISTORY(R.string.history, R.drawable.due_tone_history),
    COLLECTIONS(R.string.my_collections, R.drawable.due_tone_video_library),
    RATING(R.string.my_ratings, R.drawable.due_tone_star),
}