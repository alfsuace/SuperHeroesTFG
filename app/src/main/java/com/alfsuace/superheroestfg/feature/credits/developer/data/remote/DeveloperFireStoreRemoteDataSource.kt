package com.alfsuace.superheroestfg.feature.credits.developer.data.remote

import com.alfsuace.superheroestfg.app.domain.ErrorApp
import com.alfsuace.superheroestfg.feature.credits.developer.domain.Developer
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import org.koin.core.annotation.Single

@Single
class DeveloperFireStoreRemoteDataSource(private val firestore: FirebaseFirestore) {

    suspend fun getDeveloper(): Result<Developer?> {
        return runCatching {
            firestore
                .collection("developers")
                .get()
                .await()
                .firstOrNull()?.toObject(DeveloperEntity::class.java)?.toModel()
        }.onFailure {
            Result.failure<ErrorApp.ServerErrorApp>(it)
        }
    }
}