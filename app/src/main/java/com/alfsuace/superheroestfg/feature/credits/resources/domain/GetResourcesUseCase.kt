package com.alfsuace.superheroestfg.feature.credits.resources.domain

import org.koin.core.annotation.Single

@Single
class GetResourcesUseCase(private val repository: ResourceRepository) {

    suspend operator fun invoke(): Result<List<Resource>> {
        return repository.getResources()
    }

}