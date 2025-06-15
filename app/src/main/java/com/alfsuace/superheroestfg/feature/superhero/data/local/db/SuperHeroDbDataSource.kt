package com.alfsuace.superheroestfg.feature.superhero.data.local.db

import com.alfsuace.superheroestfg.app.domain.ErrorApp
import com.alfsuace.superheroestfg.feature.superhero.di.TIME_CACHE
import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHero
import org.koin.core.annotation.Single

@Single
class SuperHeroDbDataSource(private val dao: SuperHeroDao) {

    suspend fun saveSuperHero(superHero: SuperHero) {
        val date = getDate()
        dao.insertHeroes(superHero.toEntity(date))
    }

    private fun getDate(): Long {
        return System.currentTimeMillis()
    }

    suspend fun getById(superHeroId: String): Result<SuperHero> {
        val hero = dao.getHeroById(superHeroId.toInt())
        return if (hero != null && isInCacheTime(hero.timeStamp)) {
            Result.success(hero.toModel())
        } else if (hero != null) {
            Result.failure(ErrorApp.CacheExpiredErrorApp)
        } else {
            Result.failure(ErrorApp.DataErrorApp)
        }
    }

    suspend fun saveSuperHeroes(superHeroes: List<SuperHero>) {
        val date = getDate()
        val entities = superHeroes.map { it.toEntity(date) }
        dao.insertHeroes(*entities.toTypedArray())
    }

    suspend fun getSuperHeroes(): Result<List<SuperHero>> {
        val heroes = dao.getAllHeroes()
        heroes.firstOrNull()?.let {
            return if (isInCacheTime(heroes.first().timeStamp)) {
                Result.success(heroes.map { it.toModel() })
            } else {
                Result.failure(ErrorApp.CacheExpiredErrorApp)
            }
        }
        return Result.failure(ErrorApp.DataErrorApp)
    }

    private fun isInCacheTime(date: Long): Boolean {
        return System.currentTimeMillis() - date < TIME_CACHE
    }

    suspend fun deleteAllHeroes() {
        dao.deleteAllHeroes()
    }
}
