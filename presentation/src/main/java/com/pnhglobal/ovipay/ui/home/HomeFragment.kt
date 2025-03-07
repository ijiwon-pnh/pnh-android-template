package com.pnhglobal.ovipay.ui.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.pnhglobal.ovipay.R
import com.pnhglobal.ovipay.databinding.FragmentHomeBinding
import com.pnhglobal.ovipay.ui.base.BaseFragment
import dev.androidbroadcast.vbpd.viewBinding
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

    override val viewModel: HomeViewModel by viewModels()

    override fun setupViews() = with(binding) {
        TODO("Not yet implemented")
    }

    override fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.isLoading.collect { isLoading ->
                    }
                }

                launch {
                    viewModel.nearbyStores.collect {
                    }
                }
            }
        }
    }
}