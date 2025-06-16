package com.alfsuace.superheroestfg.feature.credits.developer.domain

interface DeveloperRepository {

    suspend fun getDeveloper(): Result<Developer>

}