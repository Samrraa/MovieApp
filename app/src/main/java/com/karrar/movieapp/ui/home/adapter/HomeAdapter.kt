package com.karrar.movieapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.karrar.movieapp.BR
import com.karrar.movieapp.R
import com.karrar.movieapp.domain.enums.HomeItemsType
import com.karrar.movieapp.ui.adapters.*
import com.karrar.movieapp.ui.base.BaseAdapter
import com.karrar.movieapp.ui.base.BaseInteractionListener
import com.karrar.movieapp.ui.home.HomeInteractionListener
import com.karrar.movieapp.ui.home.HomeItem
import com.karrar.movieapp.ui.models.MediaUi

class HomeAdapter(
    private var homeItems: MutableList<HomeItem>,
    private val listener: BaseInteractionListener,
) : BaseAdapter<HomeItem>(homeItems, listener) {
    override val layoutID: Int = 0

    fun setItem(item: HomeItem) {
        val newItems = homeItems.apply {
            removeAt(item.priority)
            add(item.priority, item)
        }
        setItems(newItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), viewType, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (homeItems.isNotEmpty())
            bind(holder as ItemViewHolder, position)
    }

    override fun bind(holder: ItemViewHolder, position: Int) {
        if (position != -1)
            when (val currentItem = homeItems[position]) {
                is HomeItem.Slider -> {
                    holder.binding.setVariable(
                        BR.adapterRecycler,
                        PopularMovieAdapter(currentItem.items, listener as HomeInteractionListener)
                    )
                }

                is HomeItem.RecentlyReleased -> {
                    holder.binding.run {
                        setVariable(
                            BR.adapterRecycler,
                            MediaAdapter(
                                currentItem.items,
                                listener as MediaInteractionListener,
                                "Recently Released"
                            )
                        )
                    }
                }

                is HomeItem.UpcomingMovies -> {
                    holder.binding.run {
                        setVariable(
                            BR.adapterRecycler,
                            MediaAdapter(
                                currentItem.items,
                                listener as MediaInteractionListener,
                                "Upcoming Movies"
                            )
                        )
                    }
                }

                is HomeItem.MatchesYourVibe -> {
                    holder.binding.run {
                        setVariable(
                            BR.adapterRecycler,
                            MediaAdapter(
                                currentItem.items,
                                listener as MediaInteractionListener,
                                "Matches your Vibe"
                            )
                        )
                    }                }

                is HomeItem.TopRatedTVShows -> {
                    holder.binding.run {
                        setVariable(
                            BR.adapterRecycler,
                            MediaAdapter(
                                currentItem.items,
                                listener as MediaInteractionListener,
                                "Top Rated TV Shows"
                            )
                        )
                    }                }

                is HomeItem.RecentlyViewed -> {
                    holder.binding.run {
                        setVariable(
                            BR.adapterRecycler,
                            MediaAdapter(
                                currentItem.items,
                                listener as MediaInteractionListener,
                                "Recently Viewed"
                            )
                        )
                    }
                }

                is HomeItem.Collections -> {
                    holder.binding.run {
                        setVariable(
                            BR.adapterRecycler,
                            CollectionAdapter(
                                currentItem.items,
                                listener as CollectionInteractionListener
                            )
                        )
                    }
                }
            }
    }

    private fun bindMovie(holder: ItemViewHolder, items: List<MediaUi>, type: HomeItemsType) {
        holder.binding.run {
            setVariable(
                BR.adapterRecycler,
                MovieAdapter(items, listener as MovieInteractionListener)
            )
            setVariable(BR.movieType, type)
        }
    }

    override fun setItems(newItems: List<HomeItem>) {
        homeItems = newItems.sortedBy { it.priority }.toMutableList()
        super.setItems(homeItems)
    }

    override fun areItemsSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
        return oldItem.priority == newItem.priority
    }

    override fun areContentSame(
        oldPosition: HomeItem,
        newPosition: HomeItem,
    ): Boolean {
        return oldPosition == newPosition
    }

    override fun getItemViewType(position: Int): Int {
        if (homeItems.isNotEmpty()) {
            return when (homeItems[position]) {
                is HomeItem.Slider -> R.layout.list_popular
                is HomeItem.RecentlyReleased,
                is HomeItem.UpcomingMovies,
                is HomeItem.MatchesYourVibe,
                is HomeItem.TopRatedTVShows,
                is HomeItem.RecentlyViewed,
                    -> R.layout.list_media

                is HomeItem.Collections -> R.layout.list_collection
            }
        }
        return -1
    }

}