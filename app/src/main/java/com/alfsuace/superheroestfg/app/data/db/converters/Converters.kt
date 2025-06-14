package com.alfsuace.superheroestfg.app.data.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromStringList(list: List<String>): String = gson.toJson(list)

    @TypeConverter
    fun toStringList(json: String): List<String> {
        return gson.fromJson(json, Array<String>::class.java).toList()
    }

}