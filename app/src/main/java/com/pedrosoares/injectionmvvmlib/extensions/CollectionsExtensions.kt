package com.pedrosoares.injectionmvvmlib.extensions

import android.databinding.ObservableList

fun <T> ObservableList<T>.replace(items: Collection<T>) {
    this.clear()
    this.addAll(items)
}