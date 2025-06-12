package com.alfsuace.superheroestfg.feature.superhero.data.local

import android.content.Context
import androidx.core.content.edit
import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHero
import com.google.gson.Gson
import org.koin.core.annotation.Single

@Single
class SuperHeroLocalDataSource(private val context: Context, private val gson: Gson) {

    private val sharedPreferences =
        context.getSharedPreferences("superheroes", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()


    fun saveSuperHero(superHero: SuperHero) {
        sharedPreferences.edit {
            putString(superHero.id.toString(), gson.toJson(superHero))
            apply()
        }
    }

    fun getById(superHeroId: String): SuperHero? {
        return sharedPreferences.getString(superHeroId, null)?.let {
            gson.fromJson(it, SuperHero::class.java)
        }
    }

    fun saveSuperHeroes(superHeroes: List<SuperHero>) {
        sharedPreferences.edit {
            superHeroes.forEach { superHero ->
                putString(superHero.id.toString(), gson.toJson(superHero))
            }
        }
    }

    fun getSuperHeroes(): List<SuperHero> {
        return sharedPreferences.all.values.mapNotNull {
            gson.fromJson(it as String, SuperHero::class.java)
        }
    }
}