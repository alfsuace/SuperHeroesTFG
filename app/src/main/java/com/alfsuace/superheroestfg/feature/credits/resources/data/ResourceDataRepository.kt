package com.alfsuace.superheroestfg.feature.credits.resources.data

import com.alfsuace.superheroestfg.feature.credits.resources.data.remote.ResourceFireStoreRemoteDataSource
import com.alfsuace.superheroestfg.feature.credits.resources.domain.Resource
import com.alfsuace.superheroestfg.feature.credits.resources.domain.ResourceRepository
import org.koin.core.annotation.Single

@Single
class ResourceDataRepository(private val remoteDataSource: ResourceFireStoreRemoteDataSource) :
    ResourceRepository {
    override suspend fun getResources(): Result<List<Resource>> {
        return remoteDataSource.getResources()
    }
}