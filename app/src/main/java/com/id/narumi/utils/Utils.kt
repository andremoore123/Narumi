package com.id.narumi.utils

import java.text.NumberFormat
import java.util.Locale

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
object Utils {
    const val ANALYTICS_BUTTON = "button_name"
    const val ANALYTIC_ONCLICK = "button_click"

    fun formatCurrency(amount: Int): String {
        val format = NumberFormat.getCurrencyInstance(Locale("en", "US"))
        format.maximumFractionDigits = 0
        return format.format(amount)
    }
}