package com.pedrosoares.injectionmvvmlib.utils

import android.support.v7.util.DiffUtil

public abstract class BaseRecyclerDiff<T>(protected val old: List<T>, protected val new: List<T>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = old.size
    override fun getNewListSize(): Int = new.size
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = haveTheSameContent(old[oldItemPosition], new[newItemPosition])

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = areTheSame(old[oldItemPosition], new[newItemPosition])

    abstract fun haveTheSameContent(old: T, new: T): Boolean

    abstract fun areTheSame(old: T, new: T): Boolean
}