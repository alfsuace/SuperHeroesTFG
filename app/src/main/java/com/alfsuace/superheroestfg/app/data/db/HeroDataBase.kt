package com.alfsuace.superheroestfg.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alfsuace.superheroestfg.app.data.db.converters.Converters
import com.alfsuace.superheroestfg.feature.superhero.data.local.db.SuperHeroDao
import com.alfsuace.superheroestfg.feature.superhero.data.local.db.SuperHeroEntity

@Database(entities = [SuperHeroEntity::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class HeroDatabase : RoomDatabase() {
    abstract fun superHeroDao(): SuperHeroDao
}
