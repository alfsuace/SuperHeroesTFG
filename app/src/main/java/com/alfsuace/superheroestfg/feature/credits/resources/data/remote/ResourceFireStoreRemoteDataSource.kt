package com.alfsuace.superheroestfg.feature.credits.resources.data.remote

import com.alfsuace.superheroestfg.app.domain.ErrorApp
import com.alfsuace.superheroestfg.feature.credits.resources.domain.Resource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import org.koin.core.annotation.Single

@Single
class ResourceFireStoreRemoteDataSource(private val firestore: FirebaseFirestore) {

    suspend fun getResources(): Result<List<Resource>> {
        return runCatching {
            firestore
                .collection("resources")
                .get()
                .await()
                .map { it.toObject(ResourceEntity::class.java).toModel() }
        }.onFailure {
            Result.failure<ErrorApp.ServerErrorApp>(it)
        }
    }
}