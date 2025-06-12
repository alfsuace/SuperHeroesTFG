package com.alfsuace.superheroestfg.feature.superhero.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.alfsuace.superheroestfg.R
import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHero

class SuperHeroAdapter : ListAdapter<SuperHero, SuperHeroViewHolder>(SuperHeroDiffUtil()) {

    lateinit var onClick: (superHeroId: String) -> Unit

    fun setEvent(onClick: (String) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_superhero, parent, false)
        return SuperHeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }

    override fun getItemCount(): Int = currentList.size
}