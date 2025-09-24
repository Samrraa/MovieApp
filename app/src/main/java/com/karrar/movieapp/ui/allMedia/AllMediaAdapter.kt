package com.karrar.movieapp.ui.allMedia

import androidx.recyclerview.widget.DiffUtil
import com.karrar.movieapp.R
import com.karrar.movieapp.ui.adapters.MediaInteractionListener
import com.karrar.movieapp.ui.base.BasePagingAdapter
import com.karrar.movieapp.ui.models.MediaUi

open class AllMediaAdapter(listener: MediaInteractionListener) :
    BasePagingAdapter<MediaUi>(MediaComparator, listener) {
    override val layoutID: Int = R.layout.item_media

    object MediaComparator : DiffUtil.ItemCallback<MediaUi>() {
        override fun areItemsTheSame(oldItem: MediaUi, newItem: MediaUi) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MediaUi, newItem: MediaUi) =
            oldItem == newItem
    }

}