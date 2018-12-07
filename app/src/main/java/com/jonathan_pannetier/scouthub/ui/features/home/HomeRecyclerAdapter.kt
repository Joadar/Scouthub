package com.jonathan_pannetier.scouthub.ui.features.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jonathan_pannetier.scouthub.R
import com.jonathan_pannetier.scouthub.base.BaseRecyclerAdapter
import com.jonathan_pannetier.scouthub.base.BaseViewHolder
import com.jonathan_pannetier.scouthub.data.models.Repository

class HomeRecyclerAdapter(context: Context, items: ArrayList<Repository> = arrayListOf()) :
    BaseRecyclerAdapter<Repository, HomeRecyclerAdapter.RepositoryViewHolder>(context, items) {

    override fun setViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_repository, parent, false)
        )
    }

    inner class RepositoryViewHolder(val view: View) :
        BaseViewHolder<Repository>(view) {
        val name: TextView = view.findViewById<TextView>(R.id.name)
        val watchers: TextView = view.findViewById<TextView>(R.id.watchers)
        val lang: TextView = view.findViewById<TextView>(R.id.lang)

        override fun bind(position: Int, data: Repository) {
            val res = view.context.resources
            name.text = res.getString(R.string.repository_name, data.name)
            watchers.text = res.getString(R.string.repository_watchers, data.watchers)
            lang.text = res.getString(R.string.repository_lang, data.language)
        }
    }
}