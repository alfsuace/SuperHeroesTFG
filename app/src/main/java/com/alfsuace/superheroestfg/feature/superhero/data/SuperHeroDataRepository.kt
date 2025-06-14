package com.alfsuace.superheroestfg.feature.superhero.data

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

    override suspend fun getSuperHeroes(): List<SuperHero> {
        val localSuperHeroes = localDataSource.getSuperHeroes()
        return if (localSuperHeroes.isEmpty()) {
            val remoteSuperHeroes = remoteDataSource.getSuperHeroes()
            localDataSource.saveSuperHeroes(remoteSuperHeroes)
            remoteSuperHeroes
        } else {
            localSuperHeroes
        }
    }

    override suspend fun getSuperHeroById(id: String): SuperHero? {
        val localSuperHero = localDataSource.getById(id)
        return if (localSuperHero == null || localSuperHero.id.toString() != id) {
            val remoteSuperHero = remoteDataSource.getSuperHero(id)
            remoteSuperHero?.let {
                localDataSource.saveSuperHero(it)
            }
            remoteSuperHero
        } else {
            localSuperHero
        }
    }

}