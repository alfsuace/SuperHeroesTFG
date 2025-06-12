package com.alfsuace.superheroestfg.app

import android.app.Application
import com.alfsuace.superheroestfg.app.data.di.AppModule
import com.alfsuace.superheroestfg.app.data.di.RemoteModule
import com.alfsuace.superheroestfg.feature.superhero.di.SuperHeroModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class SuperHeroApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SuperHeroApplication)
            modules(
                AppModule().module,
                RemoteModule().module,
                SuperHeroModule().module
            )
        }
    }
}