package com.pedrosoares.injectionmvvmlib.extensions

import android.os.Bundle

fun Bundle?.orEmpty(): Bundle = this ?: Bundle.EMPTY