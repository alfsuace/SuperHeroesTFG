package com.alfsuace.superheroestfg.feature.credits.resources.domain

interface ResourceRepository {
    suspend fun getResources(): Result<List<Resource>>
}