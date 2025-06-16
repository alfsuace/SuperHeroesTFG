package com.alfsuace.superheroestfg.app.di

import com.google.gson.Gson
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.alfsuace.superheroestfg")
class AppModule {

    @Single
    fun providerGson() = Gson()

}