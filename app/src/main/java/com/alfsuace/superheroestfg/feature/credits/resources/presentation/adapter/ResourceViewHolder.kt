package com.alfsuace.superheroestfg.feature.credits.resources.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alfsuace.superheroestfg.databinding.ViewItemResourceBinding
import com.alfsuace.superheroestfg.feature.credits.resources.domain.Resource

class ResourceViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ViewItemResourceBinding.bind(view)

    fun bind(resource: Resource) {
        binding.apply {
            itemTitle.text = resource.name
            itemSubtitle.text = resource.description
        }

    }
}