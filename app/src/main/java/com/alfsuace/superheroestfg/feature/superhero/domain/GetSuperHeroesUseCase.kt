package com.alfsuace.superheroestfg.feature.superhero.domain

import org.koin.core.annotation.Single

@Single
class GetSuperHeroesUseCase(
    private val repository: SuperHeroRepository,
    private val favoriteRepository: SuperHeroFavoriteRepository
) {

    suspend operator fun invoke(): Result<List<SuperHeroUiModel>> {
        val favoriteIds = favoriteRepository.getSuperHeroesById().toSet()
        return repository.getSuperHeroes().mapCatching { heroes ->
            heroes.map {
                SuperHeroUiModel(
                    hero = it,
                    isFavorite = it.id.toString() in favoriteIds
                )
            }
        }
    }

    data class SuperHeroUiModel(
        val hero: SuperHero,
        val isFavorite: Boolean
    )
}
