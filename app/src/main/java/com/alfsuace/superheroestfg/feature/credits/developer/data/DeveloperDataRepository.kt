package com.alfsuace.superheroestfg.feature.credits.developer.data

import com.alfsuace.superheroestfg.app.domain.ErrorApp
import com.alfsuace.superheroestfg.feature.credits.developer.data.remote.DeveloperFireStoreRemoteDataSource
import com.alfsuace.superheroestfg.feature.credits.developer.domain.Developer
import com.alfsuace.superheroestfg.feature.credits.developer.domain.DeveloperRepository
import org.koin.core.annotation.Single

@Single
class DeveloperDataRepository(
    private val remoteDataSource: DeveloperFireStoreRemoteDataSource
) : DeveloperRepository {

    override suspend fun getDeveloper(): Result<Developer> {
        val developerResult = remoteDataSource.getDeveloper().getOrNull()

        return if (developerResult != null) {
            Result.success(developerResult)
        } else {
            Result.failure(ErrorApp.ServerErrorApp)
        }
    }
}
