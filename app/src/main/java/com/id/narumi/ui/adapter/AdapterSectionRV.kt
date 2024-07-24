package com.id.narumi.ui.adapter

import com.id.narumi.base.BaseRVAdapter
import com.id.narumi.databinding.ItemRowTripBinding
import com.id.narumi.domain.trip.TripModel

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
class AdapterSectionRV(
    private val onClick: () -> Unit,
) : BaseRVAdapter<TripModel, ItemRowTripBinding>(ItemRowTripBinding::inflate) {
    override fun createViewHolder(binding: ItemRowTripBinding): RVViewHolder {
        return RVViewHolder(binding.root)
    }

    override fun initView(item: TripModel) {
        with(binding) {
            tvItemRowTripName.text = item.name
            tvItemRowTripLocation.text = item.location
            sivItemRowTripImage.setImageResource(item.imageResId)
        }
    }
}