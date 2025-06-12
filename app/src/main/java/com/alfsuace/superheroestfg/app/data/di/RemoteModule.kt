package com.alfsuace.superheroestfg.app.data.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RemoteModule {

    private val url = "https://akabab.github.io/superhero-api/api/"

    @Single
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Single
    fun provideOkHttpClient(logginInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(logginInterceptor)
            .build()
        return okHttpClient
    }

    @Single
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

}