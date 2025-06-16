package com.alfsuace.superheroestfg.feature.credits.resources.data.remote

import com.alfsuace.superheroestfg.feature.credits.resources.domain.Resource

fun ResourceEntity.toModel(): Resource {
    return Resource(
        id = id,
        name = name,
        description = description
    )
}