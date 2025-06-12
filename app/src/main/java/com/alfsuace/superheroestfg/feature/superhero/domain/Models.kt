package com.alfsuace.superheroestfg.feature.superhero.domain

data class SuperHero(
    val id: Int,
    val name: String,
    val slug: String?,
    val powerStats: PowerStats,
    val appearance: Appearance,
    val biography: Biography,
    val work: Work,
    val images: Images
)

data class PowerStats(
    val intelligence: Int,
    val strength: Int,
    val speed: Int,
    val durability: Int,
    val power: Int,
    val combat: Int
)

data class Biography(
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String?,
    val alignment: String
)

data class Appearance(
    val gender: String,
    val race: String?,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor: String,
    val hairColor: String
)

data class Work(
    val occupation: String,
    val base: String
)

data class Images(
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String
)