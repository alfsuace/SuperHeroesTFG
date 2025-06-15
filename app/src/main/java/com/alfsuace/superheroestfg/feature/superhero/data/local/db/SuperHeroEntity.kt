package com.alfsuace.superheroestfg.feature.superhero.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

const val SUPERHERO_TABLE = "superhero_table"
const val SUPERHERO_ID = "id"

@Entity(tableName = SUPERHERO_TABLE)
data class SuperHeroEntity(
    @PrimaryKey
    @ColumnInfo(name = SUPERHERO_ID)
    val id: Int,

    @ColumnInfo(name = "time_stamp")
    val timeStamp: Long,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "slug")
    val slug: String?,

    @Embedded(prefix = "power_stats_")
    val powerStats: PowerStatsEntity,

    @Embedded(prefix = "appearance_")
    val appearance: AppearanceEntity,

    @Embedded(prefix = "bio_")
    val biography: BiographyEntity,

    @Embedded(prefix = "work_")
    val work: WorkEntity,

    @Embedded(prefix = "img_")
    val images: ImagesEntity
)

data class PowerStatsEntity(
    @ColumnInfo(name = "intelligence") val intelligence: Int,
    @ColumnInfo(name = "strength") val strength: Int,
    @ColumnInfo(name = "speed") val speed: Int,
    @ColumnInfo(name = "durability") val durability: Int,
    @ColumnInfo(name = "power") val power: Int,
    @ColumnInfo(name = "combat") val combat: Int
)

data class AppearanceEntity(
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "race") val race: String?,
    @ColumnInfo(name = "height") val height: List<String>,
    @ColumnInfo(name = "weight") val weight: List<String>,
    @ColumnInfo(name = "eye_color") val eyeColor: String,
    @ColumnInfo(name = "hair_color") val hairColor: String
)


data class BiographyEntity(
    @ColumnInfo(name = "full_name") val fullName: String,
    @ColumnInfo(name = "alter_egos") val alterEgos: String,
    @ColumnInfo(name = "aliases") val aliases: List<String>,
    @ColumnInfo(name = "place_of_birth") val placeOfBirth: String,
    @ColumnInfo(name = "first_appearance") val firstAppearance: String,
    @ColumnInfo(name = "publisher") val publisher: String?,
    @ColumnInfo(name = "alignment") val alignment: String
)

data class WorkEntity(
    @ColumnInfo(name = "occupation") val occupation: String,
    @ColumnInfo(name = "base") val base: String
)

data class ImagesEntity(
    @ColumnInfo(name = "xs") val xs: String,
    @ColumnInfo(name = "sm") val sm: String,
    @ColumnInfo(name = "md") val md: String,
    @ColumnInfo(name = "lg") val lg: String
)
