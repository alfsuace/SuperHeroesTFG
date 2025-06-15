package com.alfsuace.superheroestfg.feature.superhero.data

import com.alfsuace.superheroestfg.app.domain.ErrorApp
import com.alfsuace.superheroestfg.feature.superhero.data.local.db.SuperHeroDbDataSource
import com.alfsuace.superheroestfg.feature.superhero.data.remote.SuperHeroApiRemoteDataSource
import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHero
import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHeroRepository
import org.koin.core.annotation.Single


@Single
class SuperHeroDataRepository(
    private val remoteDataSource: SuperHeroApiRemoteDataSource,
    private val localDataSource: SuperHeroDbDataSource
) : SuperHeroRepository {

    override suspend fun getSuperHeroes(): Result<List<SuperHero>> {
        return localDataSource.getSuperHeroes().onFailure { localError ->
            if (localError is ErrorApp.CacheExpiredErrorApp || localError is ErrorApp.DataErrorApp) {
                remoteDataSource.getSuperHeroes().onSuccess { remoteSuperHeroes ->
                    localDataSource.deleteAllHeroes()
                    localDataSource.saveSuperHeroes(remoteSuperHeroes)
                    remoteSuperHeroes
                }
                return remoteDataSource.getSuperHeroes()
            } else {
                Result.failure<ErrorApp>(localError)
            }
        }
    }

    override suspend fun getSuperHeroById(id: String): Result<SuperHero> {
        return localDataSource.getById(id).onFailure { hero ->
            if (hero is ErrorApp.CacheExpiredErrorApp || hero is ErrorApp.DataErrorApp) {
                return remoteDataSource.getSuperHero(id)
            }
            return Result.failure(hero)
        }
    }
}