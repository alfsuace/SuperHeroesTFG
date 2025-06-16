package com.alfsuace.superheroestfg.feature.superhero.domain

import org.koin.core.annotation.Single

@Single
class GetFavoritesSuperHeroesByNameOrSlug(
    private val favoriteHeroRepository: SuperHeroFavoriteRepository,
    private val heroRepository: SuperHeroRepository
) {

    suspend operator fun invoke(name: String): Result<List<GetSuperHeroesUseCase.SuperHeroUiModel>> {
        val favIds = favoriteHeroRepository.getSuperHeroesById().toSet()
        return heroRepository.getHeroByNameOrSlug(name).mapCatching { heroes ->
            heroes.filter { it.id.toString() in favIds }
                .map { GetSuperHeroesUseCase.SuperHeroUiModel(it, true) }
        }

    }
}