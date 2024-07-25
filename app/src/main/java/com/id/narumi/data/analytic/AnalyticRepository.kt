package com.id.narumi.data.analytic

import android.os.Bundle
import androidx.core.os.bundleOf
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.FirebaseAnalytics.Event
import com.google.firebase.analytics.logEvent
import com.id.narumi.domain.analytic.IAnalyticRepository

/**
 * Created by: andreputras.
 * Date: 25/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
class AnalyticRepository(
    private val analytic: FirebaseAnalytics,
) : IAnalyticRepository {
    override fun logScreenView(screenName: String) {
        analytic.logEvent(Event.SCREEN_VIEW, bundleOf(
            "screen_name" to screenName
        ))
    }

    override fun logSelectItem(bundle: Bundle) {
        analytic.logEvent(Event.SELECT_ITEM, bundle)
    }

    override fun logEvent(eventName: String, bundle: Bundle) {
        analytic.logEvent(eventName, bundle)
    }
}