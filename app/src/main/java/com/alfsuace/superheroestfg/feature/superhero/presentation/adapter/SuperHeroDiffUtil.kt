package com.alfsuace.superheroestfg.feature.superhero.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHero

class SuperHeroDiffUtil : DiffUtil.ItemCallback<SuperHero>() {

    override fun areItemsTheSame(oldItem: SuperHero, newItem: SuperHero): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SuperHero, newItem: SuperHero): Boolean {
        return oldItem == newItem
    }
}