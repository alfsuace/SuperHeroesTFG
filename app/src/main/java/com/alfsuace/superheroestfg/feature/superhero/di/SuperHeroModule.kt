package com.alfsuace.superheroestfg.feature.superhero.di

import com.alfsuace.superheroestfg.app.data.db.HeroDatabase
import com.alfsuace.superheroestfg.feature.superhero.data.local.db.SuperHeroDao
import com.alfsuace.superheroestfg.feature.superhero.data.remote.SuperHeroService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
@ComponentScan
class SuperHeroModule {
    @Single
    fun provideNewService(retrofit: Retrofit): SuperHeroService =
        retrofit.create(SuperHeroService::class.java)

    @Single
    fun provideSuperHeroDao(database: HeroDatabase): SuperHeroDao = database.superHeroDao()
}