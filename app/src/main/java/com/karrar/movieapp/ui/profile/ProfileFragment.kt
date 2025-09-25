package com.karrar.movieapp.ui.profile

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.karrar.movieapp.BR
import com.karrar.movieapp.R
import com.karrar.movieapp.databinding.FragmentProfileBinding
import com.karrar.movieapp.ui.base.BaseFragment
import com.karrar.movieapp.ui.profile.adapter.ShortcutsAdapter
import com.karrar.movieapp.utilities.Constants
import com.karrar.movieapp.utilities.collectLast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_profile
    override val viewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.my_profile))
        handleUiComponents()
        setAdapter()
        collectLast(viewModel.profileUIEvent) {
            it.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: ProfileUIEvent) {
        val action = when (event) {
            ProfileUIEvent.DialogLogoutEvent -> {
                ProfileFragmentDirections.actionProfileFragmentToLogoutDialog()
            }

            ProfileUIEvent.LoginEvent -> {
                ProfileFragmentDirections.actionProfileFragmentToLoginFragment(Constants.PROFILE)
            }

            ProfileUIEvent.RatedMoviesEvent -> {
                ProfileFragmentDirections.actionProfileFragmentToRatedMoviesFragment()
            }

            ProfileUIEvent.WatchHistoryEvent -> {
                ProfileFragmentDirections.actionProfileFragmentToWatchHistoryFragment()
            }
        }
        findNavController().navigate(action)
    }

    private fun handleUiComponents() {
        binding.logout.tvLabel.setTextColor(
            ContextCompat.getColor(
                requireView().context,
                R.color.additional_primary_red
            )
        )
        binding.logout.ivIcon.setColorFilter(
            ContextCompat.getColor(
                requireView().context,
                R.color.additional_primary_red
            )
        )
        binding.logout.ivArrow.setColorFilter(
            ContextCompat.getColor(
                requireView().context,
                R.color.additional_primary_red
            )
        )
    }

    private fun setAdapter() {
        binding.setVariable(BR.shortcutAdapter,ShortcutsAdapter(listener = viewModel))
    }

}