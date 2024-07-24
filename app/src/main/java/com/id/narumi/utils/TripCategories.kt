package com.id.narumi.utils

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
sealed class TripCategories(val value: String) {
    data object Popular: TripCategories("Popular")
    data object Recommended: TripCategories("Recommended")
}