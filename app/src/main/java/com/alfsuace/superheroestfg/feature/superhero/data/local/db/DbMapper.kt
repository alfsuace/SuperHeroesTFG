package com.alfsuace.superheroestfg.feature.superhero.data.local.db

import com.alfsuace.superheroestfg.feature.superhero.domain.Appearance
import com.alfsuace.superheroestfg.feature.superhero.domain.Biography
import com.alfsuace.superheroestfg.feature.superhero.domain.Images
import com.alfsuace.superheroestfg.feature.superhero.domain.PowerStats
import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHero
import com.alfsuace.superheroestfg.feature.superhero.domain.Work

fun SuperHero.toEntity(): SuperHeroEntity = SuperHeroEntity(
    id = id,
    name = name,
    slug = slug,
    powerStats = PowerStatsEntity(
        intelligence = powerStats.intelligence,
        strength = powerStats.strength,
        speed = powerStats.speed,
        durability = powerStats.durability,
        power = powerStats.power,
        combat = powerStats.combat
    ),
    appearance = AppearanceEntity(
        gender = appearance.gender,
        race = appearance.race,
        height = appearance.height,
        weight = appearance.weight,
        eyeColor = appearance.eyeColor,
        hairColor = appearance.hairColor
    ),
    biography = BiographyEntity(
        fullName = biography.fullName,
        alterEgos = biography.alterEgos,
        aliases = biography.aliases,
        placeOfBirth = biography.placeOfBirth,
        firstAppearance = biography.firstAppearance,
        publisher = biography.publisher,
        alignment = biography.alignment
    ),
    work = WorkEntity(
        occupation = work.occupation,
        base = work.base
    ),
    images = ImagesEntity(
        xs = images.xs,
        sm = images.sm,
        md = images.md,
        lg = images.lg
    )
)

fun SuperHeroEntity.toDomain(): SuperHero = SuperHero(
    id = id,
    name = name,
    slug = slug,
    powerStats = PowerStats(
        intelligence = powerStats.intelligence,
        strength = powerStats.strength,
        speed = powerStats.speed,
        durability = powerStats.durability,
        power = powerStats.power,
        combat = powerStats.combat
    ),
    appearance = Appearance(
        gender = appearance.gender,
        race = appearance.race,
        height = appearance.height,
        weight = appearance.weight,
        eyeColor = appearance.eyeColor,
        hairColor = appearance.hairColor
    ),
    biography = Biography(
        fullName = biography.fullName,
        alterEgos = biography.alterEgos,
        aliases = biography.aliases,
        placeOfBirth = biography.placeOfBirth,
        firstAppearance = biography.firstAppearance,
        publisher = biography.publisher,
        alignment = biography.alignment
    ),
    work = Work(
        occupation = work.occupation,
        base = work.base
    ),
    images = Images(
        xs = images.xs,
        sm = images.sm,
        md = images.md,
        lg = images.lg
    )
)
