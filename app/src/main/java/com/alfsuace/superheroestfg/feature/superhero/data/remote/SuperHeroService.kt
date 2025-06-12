package com.alfsuace.superheroestfg.feature.superhero.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroService {

    @GET("all.json")
    suspend fun requestSuperHeroes(): Response<List<SuperHeroApiModel>>

    @GET("id/{id}.json")
    suspend fun requestHeroById(@Path("id") id: String): Response<SuperHeroApiModel>


}