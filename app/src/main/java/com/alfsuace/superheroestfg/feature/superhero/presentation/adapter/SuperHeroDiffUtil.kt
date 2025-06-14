package com.alfsuace.superheroestfg.feature.superhero.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.alfsuace.superheroestfg.feature.superhero.domain.GetSuperHeroesUseCase

class SuperHeroDiffUtil : DiffUtil.ItemCallback<GetSuperHeroesUseCase.SuperHeroUiModel>() {

    override fun areItemsTheSame(
        oldItem: GetSuperHeroesUseCase.SuperHeroUiModel,
        newItem: GetSuperHeroesUseCase.SuperHeroUiModel
    ): Boolean {
        return oldItem.hero.id == newItem.hero.id
    }

    override fun areContentsTheSame(
        oldItem: GetSuperHeroesUseCase.SuperHeroUiModel,
        newItem: GetSuperHeroesUseCase.SuperHeroUiModel
    ): Boolean {
        return oldItem == newItem
    }
}