package com.karrar.movieapp.ui.match

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.karrar.movieapp.R
import com.karrar.movieapp.databinding.FragmentMyListsBinding
import com.karrar.movieapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MatchFragment : BaseFragment<FragmentMyListsBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_match
    override val viewModel: MatchViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(visibility = false)
    }
}