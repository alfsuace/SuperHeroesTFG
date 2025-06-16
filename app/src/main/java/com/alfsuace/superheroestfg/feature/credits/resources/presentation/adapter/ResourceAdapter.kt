package com.alfsuace.superheroestfg.feature.credits.resources.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.alfsuace.superheroestfg.R
import com.alfsuace.superheroestfg.feature.credits.resources.domain.Resource

class ResourceAdapter : ListAdapter<Resource, ResourceViewHolder>(ResourceDiffUtil()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResourceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_resource, parent, false)
        return ResourceViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ResourceViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}