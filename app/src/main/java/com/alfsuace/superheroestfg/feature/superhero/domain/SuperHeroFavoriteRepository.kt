package com.alfsuace.superheroestfg.feature.superhero.domain

interface SuperHeroFavoriteRepository {
    fun getSuperHeroesById(): List<String>
    fun saveSuperHeroById(superHeroId: String)
    fun deleteSuperHeroById(superHero: String)
}