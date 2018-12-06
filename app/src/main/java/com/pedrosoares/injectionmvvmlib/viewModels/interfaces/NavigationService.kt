package tassks.agap2.com.common_core.interfaces

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

interface NavigationService {
    fun <T : AppCompatActivity> navigateTo(activity: Class<T>, addCurrentToBackStack: Boolean = true, bundle: Bundle = Bundle())
    fun <T : AppCompatActivity> navigateBackTo(activity: Class<T>, bundle: Bundle = Bundle())
    fun <T : AppCompatActivity> navigateBackToAndResetStack(activity: Class<T>, bundle: Bundle = Bundle())
    fun <T : AppCompatActivity> navigateToWithSharedElement(activity: Class<T>, sharedViewId: Int, sharedElementTransitionName: String, bundle: Bundle = Bundle())
    fun back()
}