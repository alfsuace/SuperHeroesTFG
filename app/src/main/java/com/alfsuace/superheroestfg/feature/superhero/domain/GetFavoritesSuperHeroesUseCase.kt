package com.alfsuace.superheroestfg.feature.superhero.domain

import org.koin.core.annotation.Single

@Single
class GetFavoritesSuperHeroesUseCase(
    private val favoriteHeroRepository: SuperHeroFavoriteRepository,
    private val heroRepository: SuperHeroRepository
) {
    suspend operator fun invoke(): List<GetSuperHeroesUseCase.SuperHeroUiModel> {
        val favIds = favoriteHeroRepository.getSuperHeroesById().toSet()
        return heroRepository.getSuperHeroes()
            .filter { it.id.toString() in favIds }
            .map { GetSuperHeroesUseCase.SuperHeroUiModel(it, true) }
    }

}