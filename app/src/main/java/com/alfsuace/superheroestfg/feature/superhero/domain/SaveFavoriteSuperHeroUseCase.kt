package com.alfsuace.superheroestfg.feature.superhero.domain

import org.koin.core.annotation.Single

@Single
class SaveFavoriteSuperHeroUseCase(private val repository: SuperHeroFavoriteRepository) {

    operator fun invoke(superHeroId: String) {
        repository.saveSuperHeroById(superHeroId)
    }

}