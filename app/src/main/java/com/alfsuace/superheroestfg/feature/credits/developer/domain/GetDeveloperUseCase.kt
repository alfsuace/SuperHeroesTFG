package com.alfsuace.superheroestfg.feature.credits.developer.domain

import org.koin.core.annotation.Single

@Single
class GetDeveloperUseCase(private val repository: DeveloperRepository) {
    suspend operator fun invoke(): Result<Developer> {
        return repository.getDeveloper()
    }
}