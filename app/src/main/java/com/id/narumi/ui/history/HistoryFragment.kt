package com.id.narumi.ui.history

import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.id.narumi.R
import com.id.narumi.base.BaseFragment
import com.id.narumi.databinding.FragmentHistoryBinding
import com.id.narumi.ui.adapter.AdapterHistoryRV
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class HistoryFragment : BaseFragment<FragmentHistoryBinding, HistoryViewModel>(
    FragmentHistoryBinding::inflate
), AndroidScopeComponent {
    override val viewModel: HistoryViewModel by viewModel()
    override val scope: Scope by fragmentScope()

    private val rvAdapter = AdapterHistoryRV()

    override fun initView() {
        binding.fhRvHistory.run {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.historyPageToolbar.run {
            ivToolbarArrowBackIcon.visibility = View.GONE
            tvToolbarTitle.text = getString(R.string.text_history)
        }
    }

    override fun observeData() {
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.history.collect {
                rvAdapter.insertData(it)
            }
        }
    }
}