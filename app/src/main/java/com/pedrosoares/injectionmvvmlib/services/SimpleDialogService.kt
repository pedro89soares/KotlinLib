package com.pedrosoares.injectionmvvmlib.services

import android.content.Context
import android.support.design.widget.Snackbar
import android.widget.Toast
import com.pedrosoares.injectionmvvmlib.extensions.rootView
import com.pedrosoares.injectionmvvmlib.interfaces.DialogService
import javax.inject.Inject

class SimpleDialogService @Inject constructor(private val context: Context, private val currentActivityTracker: CurrentActivityTracker) : DialogService {

    private val currentActivity get() = currentActivityTracker.currentActivity

    override fun ShowToast(text: String) {
        if (currentActivity == null) return
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    override fun ShowSnackBar(text: String) {
        if (currentActivity == null || currentActivity.rootView == null)
            return
        else
            Snackbar.make(currentActivity.rootView!!, text, Snackbar.LENGTH_LONG).show()
    }
}