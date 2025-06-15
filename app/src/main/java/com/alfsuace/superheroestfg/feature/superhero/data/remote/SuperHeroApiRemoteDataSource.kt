package com.alfsuace.superheroestfg.feature.superhero.data.remote

import com.alfsuace.superheroestfg.app.extensions.apiCall
import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHero
import org.koin.core.annotation.Single

@Single
class SuperHeroApiRemoteDataSource(private val service: SuperHeroService) {

    suspend fun getSuperHeroes(): Result<List<SuperHero>> {
        return apiCall {
            service.requestSuperHeroes()
        }.mapCatching { listApiHero ->
            listApiHero.map { it.toDomain() }
        }
    }

    suspend fun getSuperHero(id: String): Result<SuperHero> {
        return apiCall {
            service.requestHeroById(id)
        }.map { it.toDomain() }
    }

}