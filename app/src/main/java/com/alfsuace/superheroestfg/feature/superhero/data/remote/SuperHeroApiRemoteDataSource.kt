package com.alfsuace.superheroestfg.feature.superhero.data.remote

import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHero
import org.koin.core.annotation.Single

@Single
class SuperHeroApiRemoteDataSource(private val service: SuperHeroService) {

    suspend fun getSuperHeroes(): List<SuperHero> {
        return service.requestSuperHeroes().body()?.map { it.toDomain() } ?: emptyList()
    }

    suspend fun getSuperHero(id: String): SuperHero? {
        return service.requestHeroById(id).body()?.toDomain()
    }

}