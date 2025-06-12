package com.alfsuace.superheroestfg.feature.superhero.domain

import org.koin.core.annotation.Single

@Single
class GetSuperHeroesUseCase(private val repository: SuperHeroRepository) {

    suspend operator fun invoke(): List<SuperHeroUiModel> {
        return repository.getSuperHeroes().map {
            SuperHeroUiModel(it, isFavorite = false)
        }
    }

    data class SuperHeroUiModel(val hero: SuperHero, var isFavorite: Boolean)
}