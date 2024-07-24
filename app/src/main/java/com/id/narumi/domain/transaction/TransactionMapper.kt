package com.id.narumi.domain.transaction

import com.id.narumi.data.transaction.model.TransactionEntity

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
object TransactionMapper {
    fun mapEntityToModel(q: TransactionEntity) = TransactionModel(
        uuid = q.uuid,
        imageResId = q.imageResId,
        name = q.name,
        location = q.location,
        orderDate = q.orderDate,
        duration = q.duration,
        totalCost = q.totalCost
    )
}