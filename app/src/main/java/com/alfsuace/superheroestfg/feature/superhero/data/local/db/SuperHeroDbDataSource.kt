package com.alfsuace.superheroestfg.feature.superhero.data.local.db

import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHero
import org.koin.core.annotation.Single

@Single
class SuperHeroDbDataSource(private val dao: SuperHeroDao) {

    suspend fun saveSuperHero(superHero: SuperHero) {
        dao.insertHeroes(superHero.toEntity())
    }

    suspend fun getById(superHeroId: String): SuperHero? {
        return dao.getHeroById(superHeroId.toInt())?.toDomain()
    }

    suspend fun saveSuperHeroes(superHeroes: List<SuperHero>) {
        val entities = superHeroes.map { it.toEntity() }
        dao.insertHeroes(*entities.toTypedArray())
    }

    suspend fun getSuperHeroes(): List<SuperHero> {
        return dao.getAllHeroes().map { it.toDomain() }
    }
}
