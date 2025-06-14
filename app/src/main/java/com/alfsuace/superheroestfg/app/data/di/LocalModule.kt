package com.alfsuace.superheroestfg.app.data.di

import android.content.Context
import androidx.room.Room
import com.alfsuace.superheroestfg.app.data.db.HeroDatabase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class LocalModule {

    @Single
    fun provideDataBase(context: Context): HeroDatabase {
        val db = Room.databaseBuilder(
            context,
            HeroDatabase::class.java,
            "hero-db"
        )
        db.fallbackToDestructiveMigration()
        return db.build()
    }
}