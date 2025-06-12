package com.alfsuace.superheroestfg.feature.superhero.data.remote

import com.google.gson.annotations.SerializedName

data class SuperHeroApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String?,
    @SerializedName("powerstats") val powerStats: PowerStatsApiModel,
    @SerializedName("appearance") val appearance: AppearanceApiModel,
    @SerializedName("biography") val biography: BiographyApiModel,
    @SerializedName("work") val work: WorkApiModel,
    @SerializedName("images") val images: ImagesApiModel
)

data class PowerStatsApiModel(
    @SerializedName("intelligence") val intelligence: Int,
    @SerializedName("strength") val strength: Int,
    @SerializedName("speed") val speed: Int,
    @SerializedName("durability") val durability: Int,
    @SerializedName("power") val power: Int,
    @SerializedName("combat") val combat: Int
)

data class BiographyApiModel(
    @SerializedName("fullName") val fullName: String,
    @SerializedName("alterEgos") val alterEgos: String,
    @SerializedName("aliases") val aliases: List<String>,
    @SerializedName("placeOfBirth") val placeOfBirth: String,
    @SerializedName("firstAppearance") val firstAppearance: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("alignment") val alignment: String
)

data class AppearanceApiModel(
    @SerializedName("gender") val gender: String,
    @SerializedName("race") val race: String?,
    @SerializedName("height") val height: List<String>,
    @SerializedName("weight") val weight: List<String>,
    @SerializedName("eyeColor") val eyeColor: String,
    @SerializedName("hairColor") val hairColor: String
)

data class WorkApiModel(
    @SerializedName("occupation") val occupation: String,
    @SerializedName("base") val base: String
)

data class ImagesApiModel(
    @SerializedName("xs") val xs: String,
    @SerializedName("sm") val sm: String,
    @SerializedName("md") val md: String,
    @SerializedName("lg") val lg: String
)
