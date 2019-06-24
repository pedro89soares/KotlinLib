package com.pedrosoares.injectionmvvmlib.interfaces

interface SharedPreferencesService {

    fun getString(key: String, defaultValue: String): String
    fun getInt(key: String, defaultValue: Int): Int
    fun getBoolean(key: String, defaultValue: Boolean): Boolean

    fun setString(key: String, value: String)
    fun setInt(key: String, value: Int)
    fun setBoolean(key: String, value: Boolean)
}