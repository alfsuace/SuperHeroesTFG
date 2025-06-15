package com.alfsuace.superheroestfg.feature.superhero.domain

interface SuperHeroRepository {

    suspend fun getSuperHeroes(): Result<List<SuperHero>>
    suspend fun getSuperHeroById(id: String): Result<SuperHero>

}