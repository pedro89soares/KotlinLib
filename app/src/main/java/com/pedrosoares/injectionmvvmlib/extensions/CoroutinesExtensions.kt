package com.pedrosoares.injectionmvvmlib.extensions

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

suspend fun <T> Deferred<T>.safelyGet(onSuccessCallback: suspend (T) -> Unit = {}, onErrorCallback: suspend (Exception) -> Unit = {}): T? {
    return try {
        this.await().also {
            onSuccessCallback(it)
        }
    } catch (e: Exception) {
        launch(UI) { onErrorCallback(e) }
        null
    }
}