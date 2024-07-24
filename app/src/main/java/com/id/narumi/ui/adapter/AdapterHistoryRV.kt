package com.id.narumi.ui.adapter

import com.id.narumi.base.BaseRVAdapter
import com.id.narumi.databinding.ItemRowTripHistoryBinding
import com.id.narumi.domain.transaction.TransactionModel
import com.id.narumi.utils.Utils.formatCurrency

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
class AdapterHistoryRV : BaseRVAdapter<TransactionModel, ItemRowTripHistoryBinding>(
    ItemRowTripHistoryBinding::inflate
) {
    override fun createViewHolder(binding: ItemRowTripHistoryBinding): RVViewHolder {
        return RVViewHolder(binding.root)
    }

    override fun initView(item: TransactionModel) {
        with(binding) {
            tvItemRowHistoryTripName.text = item.name
            tvItemRowHistoryTripCost.text = formatCurrency(item.totalCost)
            tvItemRowHistoryTripDuration.text = item.duration
            tvItemRowHistoryTripLocation.text = item.location
            tvItemRowHistoryTripOrderDate.text = item.orderDate
            sivItemRowHistoryTripImage.setImageResource(item.imageResId)
        }
    }
}