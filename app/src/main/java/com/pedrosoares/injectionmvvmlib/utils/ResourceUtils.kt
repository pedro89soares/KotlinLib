package tassks.agap2.com.common_core.utils

import android.content.Context
import javax.inject.Inject

class ResourceUtils @Inject constructor() {

    @Inject
    lateinit var applicationContext: Context

    fun getString(resource: Int): String {
        return applicationContext.getString(resource)
    }
}