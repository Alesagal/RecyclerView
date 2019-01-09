package com.alesagal.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class MyRecyclerAdapter<VH : RecyclerView.ViewHolder>(
    private val mData: Collection<*>,
    private val layoutId: Int,
    private val viewHolderClass: Class<out RecyclerView.ViewHolder>
) : RecyclerView.Adapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return viewHolderClass.constructors[0].newInstance(view) as VH
    }

    override fun getItemCount() = mData.size
}