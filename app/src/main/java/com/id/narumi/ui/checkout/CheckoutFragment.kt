package com.id.narumi.ui.checkout

import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.id.narumi.base.BaseFragment
import com.id.narumi.databinding.FragmentCheckoutBinding
import com.id.narumi.utils.Utils.formatCurrency
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class CheckoutFragment : BaseFragment<FragmentCheckoutBinding, CheckoutViewModel>(
    FragmentCheckoutBinding::inflate
), AndroidScopeComponent {
    override val viewModel: CheckoutViewModel by viewModel()
    override val scope: Scope by fragmentScope()

    private val args: CheckoutFragmentArgs by navArgs()
    private lateinit var navController: NavController

    override fun initView() {
        viewModel.fetchTripById(args.tripId)

        navController = findNavController()

        viewModel.tripData.observe(viewLifecycleOwner) {
            with(binding) {
                ivCheckoutPageTripImage.setImageResource(it.imageResId)
                tvCheckoutPageTripName.text = it.name
                tvCheckoutPageTripLocation.text = it.location
                tvCheckoutPageTripNameDetail.text = it.name
                tvCheckoutPageTripLocationDetail.text = it.location
                tvCheckoutPageTripDateDetail.text = it.date
                tvCheckoutPageTripDurationDetail.text = it.duration
                tvCheckoutPageTripCost.text = formatCurrency(it.cost)

                checkoutPageToolbar.tvToolbarTitle.text = it.name
            }
        }
    }

    override fun listenData() {
        with(viewModel) {
            itemPax.observe(viewLifecycleOwner) {
                val totalCostFormatted = formatCurrency(countTotalCost(it))
                
                binding.tvCheckoutPageTripCount.text = it.toString()
                binding.tvCheckoutPageTripCost.text = totalCostFormatted
            }
        }
    }

    override fun initListener() {
        with(binding) {
            ivCheckoutPageAdditionIcon.setOnClickListener {
                viewModel.increaseItemPax()
            }
            ivCheckoutPageSubtractionIcon.setOnClickListener {
                viewModel.decreaseItemPax()
            }

            checkoutPageToolbar.ivToolbarArrowBackIcon.setOnClickListener {
                onBackClickListener()
            }

            btnCheckoutPageBookNow.setOnClickListener {
                viewModel.checkout()
                navigateToHistory()
            }
        }
    }

    private fun onBackClickListener() {
        navController.popBackStack()
    }

    private fun navigateToHistory() {
        val action = CheckoutFragmentDirections.actionCheckoutFragmentToHistoryFragment()
        navController.navigate(action)
    }
}