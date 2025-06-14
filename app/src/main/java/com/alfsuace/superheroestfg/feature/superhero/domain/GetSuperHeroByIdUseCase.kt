package com.alfsuace.superheroestfg.feature.superhero.domain

import org.koin.core.annotation.Single

@Single
class GetSuperHeroByIdUseCase(private val repository: SuperHeroRepository) {

    suspend operator fun invoke(id: String): SuperHero? {
        return repository.getSuperHeroById(id)
    }
}