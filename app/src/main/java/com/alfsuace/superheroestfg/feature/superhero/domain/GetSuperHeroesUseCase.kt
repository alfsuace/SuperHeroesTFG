package com.alfsuace.superheroestfg.feature.superhero.domain

import org.koin.core.annotation.Single

@Single
class GetSuperHeroesUseCase(private val repository: SuperHeroRepository) {

    suspend operator fun invoke(): List<SuperHero> {
        return repository.getSuperHeroes()
    }

}