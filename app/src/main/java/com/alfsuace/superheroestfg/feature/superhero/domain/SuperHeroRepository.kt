package com.alfsuace.superheroestfg.feature.superhero.domain

interface SuperHeroRepository {

    suspend fun getSuperHeroes(): List<SuperHero>
    suspend fun getSuperHero(id: String): SuperHero?

}