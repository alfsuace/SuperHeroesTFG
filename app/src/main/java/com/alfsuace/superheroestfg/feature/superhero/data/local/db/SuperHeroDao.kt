package com.alfsuace.superheroestfg.feature.superhero.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SuperHeroDao {

    @Query("SELECT * FROM $SUPERHERO_TABLE")
    suspend fun getAllHeroes(): List<SuperHeroEntity>

    @Query("SELECT * FROM $SUPERHERO_TABLE WHERE $SUPERHERO_ID = :id")
    suspend fun getHeroById(id: Int): SuperHeroEntity?

    @Query("DELETE FROM $SUPERHERO_TABLE")
    suspend fun deleteAllHeroes()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroes(vararg superHeroes: SuperHeroEntity)

}
