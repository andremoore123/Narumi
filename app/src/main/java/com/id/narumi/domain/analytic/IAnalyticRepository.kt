package com.id.narumi.domain.analytic

import android.os.Bundle

/**
 * Created by: andreputras.
 * Date: 25/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
interface IAnalyticRepository {
    fun logScreenView(screenName: String)
    fun logSelectItem(bundle: Bundle)
    fun logEvent(eventName: String, bundle: Bundle)
}