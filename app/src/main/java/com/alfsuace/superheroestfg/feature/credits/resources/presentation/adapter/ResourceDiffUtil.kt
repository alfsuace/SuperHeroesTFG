package com.alfsuace.superheroestfg.feature.credits.resources.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.alfsuace.superheroestfg.feature.credits.resources.domain.Resource

class ResourceDiffUtil : DiffUtil.ItemCallback<Resource>() {
    override fun areItemsTheSame(
        oldItem: Resource,
        newItem: Resource
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Resource,
        newItem: Resource
    ): Boolean {
        return oldItem == newItem
    }
}