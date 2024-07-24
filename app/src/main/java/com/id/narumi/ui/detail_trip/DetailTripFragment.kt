package com.id.narumi.ui.detail_trip

import androidx.navigation.fragment.navArgs
import com.id.narumi.base.BaseFragment
import com.id.narumi.databinding.FragmentDetailTripBinding
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class DetailTripFragment : BaseFragment<FragmentDetailTripBinding, DetailTripViewModel>(
    FragmentDetailTripBinding::inflate
), AndroidScopeComponent {
    private val args: DetailTripFragmentArgs by navArgs<DetailTripFragmentArgs>()

    override val viewModel: DetailTripViewModel by viewModel()
    override val scope: Scope by fragmentScope()

    override fun initView() {
        viewModel.fetchTripById(args.tripId)
        viewModel.tripData.observe(viewLifecycleOwner) { tripData ->
            with(binding) {
                ivDetailPageTripImage.setImageResource(tripData.imageResId)
                tvDetailPageTripName.text = tripData.name
                tvDetailPageTripLocation.text = tripData.location
                tvDetailPageTripDuration.text = tripData.duration
                tvDetailPageTripDate.text = tripData.date
                tvDetailPageTripDescription.text = tripData.description

                btnDetailPageBookNow.setOnClickListener {
                    navigateToCheckout(tripData.uuid)
                }
            }
        }
    }

    override fun initListener() {
        binding.cvDetailPageArrowBackIconContainer.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun navigateToCheckout(id: String) {

    }
}