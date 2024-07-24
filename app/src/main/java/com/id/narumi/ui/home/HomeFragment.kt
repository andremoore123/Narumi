package com.id.narumi.ui.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.id.narumi.R
import com.id.narumi.base.BaseFragment
import com.id.narumi.databinding.FragmentHomeBinding
import com.id.narumi.ui.adapter.AdapterHomePopularRV
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
        rvPopularHomeAdapter = AdapterHomePopularRV {

        }
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

    override fun listenData() {
        with(viewModel) {
            fetchPopularList()
            fetchProfileData()
        }
    }
}