package com.pedrosoares.injectionmvvmlib.services

import android.content.Context
import com.pedrosoares.injectionmvvmlib.interfaces.SharedPreferencesService
import javax.inject.Inject

class SimpleSharedPreferencesService @Inject constructor(private val context: Context) : SharedPreferencesService {

    companion object {
        const val preferencesKey = "LibPreferences"
        const val preferencesMode = Context.MODE_PRIVATE
    }

    private val preferences get() = context.getSharedPreferences(preferencesKey, preferencesMode)

    override fun getString(key: String, defaultValue: String): String {
        return preferences.getString(key, defaultValue)
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return preferences.getInt(key, defaultValue)
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return preferences.getBoolean(key, defaultValue)
    }

    override fun setString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    override fun setInt(key: String, value: Int) {
        preferences.edit().putInt(key, value).apply()
    }

    override fun setBoolean(key: String, value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }
}