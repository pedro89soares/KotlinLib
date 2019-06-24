package com.pedrosoares.injectionmvvmlib.adapters

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

public class RecyclerAdapter<T>(private var items: List<T>,
                                private val create: (LayoutInflater, ViewGroup, Int) -> RecyclerView.ViewHolder,
                                private val bind: (RecyclerView.ViewHolder, T) -> Unit,
                                private val updateDiff: (List<T>, List<T>) -> DiffUtil.Callback? = { _, _ -> null }) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return create.invoke(LayoutInflater.from(parent.context), parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bind.invoke(holder, items[position])
    }

    fun update(list: List<T>) {
        val diff = updateDiff.invoke(items, list)
        items = list
        if (diff == null)
            notifyDataSetChanged()
        else {
            val result = DiffUtil.calculateDiff(diff)
            result.dispatchUpdatesTo(this)
        }
    }
}