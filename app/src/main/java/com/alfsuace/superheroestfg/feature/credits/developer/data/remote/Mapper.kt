package com.alfsuace.superheroestfg.feature.credits.developer.data.remote

import com.alfsuace.superheroestfg.feature.credits.developer.domain.Developer

fun DeveloperEntity.toModel(): Developer {
    return Developer(
        id = id,
        name = name,
    )
}