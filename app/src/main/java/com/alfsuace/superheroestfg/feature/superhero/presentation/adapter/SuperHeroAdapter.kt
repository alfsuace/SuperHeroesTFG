package com.alfsuace.superheroestfg.feature.superhero.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.alfsuace.superheroestfg.R
import com.alfsuace.superheroestfg.feature.superhero.domain.GetSuperHeroesUseCase

class SuperHeroAdapter :
    ListAdapter<GetSuperHeroesUseCase.SuperHeroUiModel, SuperHeroViewHolder>(SuperHeroDiffUtil()) {

    lateinit var onClick: (superHeroId: String) -> Unit
    lateinit var onFavoriteClick: (superHeroId: String, isFavorite: Boolean) -> Unit

    fun setEvent(
        onClick: (String) -> Unit,
        onFavoriteClick: (String, Boolean) -> Unit
    ) {
        this.onClick = onClick
        this.onFavoriteClick = onFavoriteClick
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_superhero, parent, false)
        return SuperHeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(getItem(position), onClick, onFavoriteClick)
    }

    override fun getItemCount(): Int = currentList.size
}