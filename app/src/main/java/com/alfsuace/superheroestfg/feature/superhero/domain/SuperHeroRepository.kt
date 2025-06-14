package com.alfsuace.superheroestfg.feature.superhero.domain

interface SuperHeroRepository {

    suspend fun getSuperHeroes(): List<SuperHero>
    suspend fun getSuperHeroById(id: String): SuperHero?

}