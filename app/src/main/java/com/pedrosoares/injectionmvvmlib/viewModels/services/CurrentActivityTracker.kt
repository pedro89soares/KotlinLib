package tassks.agap2.com.common_core.services

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

class CurrentActivityTracker @Inject constructor(app: Application) : Application.ActivityLifecycleCallbacks {

    var currentActivity: AppCompatActivity? = null

    init {
        app.registerActivityLifecycleCallbacks(this)
    }

    private fun clearCurrentActivity(activity: Activity?) {
        if (activity == currentActivity)
            currentActivity = null
    }

    private fun setCurrentActivity(activity: Activity?) {
        if (activity is AppCompatActivity)
            currentActivity = activity
    }

    override fun onActivityStarted(activity: Activity?) {
        setCurrentActivity(activity)
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        setCurrentActivity(activity)
    }

    override fun onActivityResumed(activity: Activity?) {
        setCurrentActivity(activity)
    }

    override fun onActivityDestroyed(activity: Activity?) {
        clearCurrentActivity(activity)
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        clearCurrentActivity(activity)
    }

    override fun onActivityStopped(activity: Activity?) {
        clearCurrentActivity(activity)
    }

    override fun onActivityPaused(activity: Activity?) {
        clearCurrentActivity(activity)
    }
}