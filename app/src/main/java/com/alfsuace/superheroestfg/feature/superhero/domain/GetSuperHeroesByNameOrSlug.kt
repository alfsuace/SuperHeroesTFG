package com.alfsuace.superheroestfg.feature.superhero.domain

import org.koin.core.annotation.Single

@Single
class SearchSuperHeroesUseCase(
    private val heroRepository: SuperHeroRepository,
    private val favoriteRepository: SuperHeroFavoriteRepository
) {

    suspend operator fun invoke(query: String): Result<List<GetSuperHeroesUseCase.SuperHeroUiModel>> {
        val favoriteIds = favoriteRepository.getSuperHeroesById().toSet()
        return heroRepository.getHeroByNameOrSlug(query).mapCatching { heroes ->
            heroes.map {
                GetSuperHeroesUseCase.SuperHeroUiModel(
                    hero = it,
                    isFavorite = it.id.toString() in favoriteIds
                )
            }
        }
    }
}
