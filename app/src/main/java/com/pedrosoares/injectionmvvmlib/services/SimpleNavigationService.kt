package com.pedrosoares.injectionmvvmlib.services

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.pedrosoares.injectionmvvmlib.interfaces.NavigationService
import javax.inject.Inject

class SimpleNavigationService @Inject constructor(private val context: Context, private val activityTracker: CurrentActivityTracker) : NavigationService {

    private val currentActivity
        get() = activityTracker.currentActivity


    override fun <T : AppCompatActivity> navigateTo(activity: Class<T>, addCurrentToBackStack: Boolean, bundle: Bundle) {
        val intent = Intent(context, activity)
        intent.putExtras(bundle)
        if (!addCurrentToBackStack)
            currentActivity?.finish()
        currentActivity?.startActivity(intent)
    }

    override fun <T : AppCompatActivity> navigateBackTo(activity: Class<T>, bundle: Bundle) {
        val intent = Intent(context, activity)
        intent.putExtras(bundle)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        currentActivity?.startActivity(intent)
    }

    override fun <T : AppCompatActivity> navigateBackToAndResetStack(activity: Class<T>, bundle: Bundle) {
        val intent = Intent(context, activity)
        intent.putExtras(bundle)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
        currentActivity?.startActivity(intent)
    }

    override fun <T : AppCompatActivity> navigateToWithSharedElement(activity: Class<T>, sharedViewId: Int, sharedElementTransitionName: String, bundle: Bundle) {
        val intent = Intent(context, activity)
        val view = currentActivity!!.findViewById<View>(sharedViewId)
        val optBundle = ActivityOptionsCompat.makeSceneTransitionAnimation(currentActivity!!, view, sharedElementTransitionName).toBundle()
        optBundle?.putAll(bundle)
        currentActivity?.startActivity(intent, optBundle)
    }

    override fun back() {
        currentActivity?.onBackPressed()
    }
}