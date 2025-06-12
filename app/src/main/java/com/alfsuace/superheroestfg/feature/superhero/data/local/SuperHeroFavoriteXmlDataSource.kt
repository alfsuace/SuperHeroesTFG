package com.alfsuace.superheroestfg.feature.superhero.data.local

import android.content.Context
import androidx.core.content.edit
import com.alfsuace.superheroestfg.R
import com.google.gson.Gson
import org.koin.core.annotation.Single

@Single
class SuperHeroFavoriteXmlDataSource(
    private val context: Context,
    private val gson: Gson
) {
    private val sharedPreferences =
        context.getSharedPreferences(
            context.getString(R.string.shared_prefs_favorite_superheroes),
            Context.MODE_PRIVATE
        )

    fun saveSuperHeroesById(superHeroId: String) {
        sharedPreferences.edit {
            putString(superHeroId, superHeroId)
            apply()
        }
    }

    fun getSuperHeroIds(): List<String> {
        return sharedPreferences.all.values.mapNotNull {
            it as String
        }
    }

    fun deleteSuperHeroById(superHeroId: String) {
        sharedPreferences.edit {
            remove(superHeroId)
            apply()
        }
    }

}