package com.id.narumi.ui.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.id.narumi.R
import com.id.narumi.base.BaseFragment
import com.id.narumi.databinding.FragmentHomeBinding
import com.id.narumi.ui.adapter.AdapterHomePopularRV
import com.id.narumi.ui.adapter.SectionsPagerAdapter
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
), AndroidScopeComponent {
    override val viewModel: HomeViewModel by viewModel()
    override val scope: Scope by fragmentScope()

    private lateinit var rvPopularHomeAdapter: AdapterHomePopularRV

    override fun initView() {
        viewModel.fetchAllData()
        rvPopularHomeAdapter = AdapterHomePopularRV {

        }

        setTabLayout()
        with(binding) {
            rvHomePagePopularDestination.run {
                adapter = rvPopularHomeAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }

    override fun observeData() {
        with(viewModel) {
            popularList.observe(viewLifecycleOwner) {
                rvPopularHomeAdapter.insertData(it)
            }
            userData.observe(viewLifecycleOwner) {
                val welcomeMessage = resources.getString(R.string.welcome_message, it.name)
                binding.tvHomePageWelcomeMessage.text = welcomeMessage
            }
        }
    }
    private fun setTabLayout() {
        viewModel.popularList.observe(viewLifecycleOwner) {
            val fragments = listOf(
                SectionFragment.newInstance(viewModel.allTrips.value ?: listOf()),
                SectionFragment.newInstance(viewModel.popularList.value ?: listOf()),
                SectionFragment.newInstance(viewModel.recommendedList.value ?: listOf()),
            )

            val adapter = SectionsPagerAdapter(requireActivity(), fragments)
            binding.vpHomePage.adapter = adapter

            TabLayoutMediator(binding.tlHomePage, binding.vpHomePage) { tab, position ->
                tab.text = when (position) {
                    0 -> "All"
                    1 -> "Popular"
                    2 -> "Recommended"
                    else -> null
                }
            }.attach()
        }
    }
}