package com.alfsuace.superheroestfg.feature.superhero.data

import com.alfsuace.superheroestfg.feature.superhero.data.local.SuperHeroFavoriteXmlDataSource
import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHeroFavoriteRepository
import org.koin.core.annotation.Single

@Single
class SuperHeroFavoriteDataRepository(private val dataSource: SuperHeroFavoriteXmlDataSource) :
    SuperHeroFavoriteRepository {
    override fun getSuperHeroesById(): List<String> {
        return dataSource.getSuperHeroIds()
    }

    override fun saveSuperHeroById(superHeroId: String) {
        return dataSource.saveSuperHeroesById(superHeroId)
    }

    override fun deleteSuperHeroById(superHero: String) {
        dataSource.deleteSuperHeroById(superHero)
    }

}