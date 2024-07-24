package com.id.narumi.ui.adapter

import com.id.narumi.base.BaseRVAdapter
import com.id.narumi.databinding.ItemRowTripPopularDestinationBinding
import com.id.narumi.domain.trip.TripModel

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
class AdapterHomePopularRV(
    private val onClick: (TripModel) -> Unit
): BaseRVAdapter<TripModel, ItemRowTripPopularDestinationBinding>(
    ItemRowTripPopularDestinationBinding::inflate
) {
    override fun createViewHolder(binding: ItemRowTripPopularDestinationBinding): RVViewHolder {
        return RVViewHolder(binding.root)
    }

    override fun initView(item: TripModel) {
        with(binding) {
            root.setOnClickListener {
                onClick(item)
            }
            tvItemRowPopularDestinationTripName.text = item.name
            sivItemRowPopularDestinationTripImage.setImageResource(item.imageResId)
            tvItemRowPopularDestinationTripLocation.text = item.location
        }
    }
}