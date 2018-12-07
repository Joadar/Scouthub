package com.jonathan_pannetier.scouthub.base

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(position: Int, data: T)
}