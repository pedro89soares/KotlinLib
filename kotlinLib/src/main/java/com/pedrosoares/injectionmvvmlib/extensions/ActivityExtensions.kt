package com.pedrosoares.injectionmvvmlib.extensions

import android.support.v7.app.AppCompatActivity
import android.view.View

public val AppCompatActivity?.rootView get() = this?.findViewById<View>(android.R.id.content)