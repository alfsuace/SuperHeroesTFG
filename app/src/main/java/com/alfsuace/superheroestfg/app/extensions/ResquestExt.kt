package com.alfsuace.superheroestfg.app.extensions

import com.alfsuace.superheroestfg.app.domain.ErrorApp
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): Result<T> {
    val response: Response<T>
    try {
        response = call.invoke()
    } catch (exception: Throwable) {
        return when (exception) {
            is ConnectException -> Result.failure(ErrorApp.InternetErrorApp)
            is UnknownHostException -> Result.failure(ErrorApp.ServerErrorApp)
            is SocketTimeoutException -> Result.failure(ErrorApp.InternetErrorApp)
            else -> Result.failure(ErrorApp.UnknownErrorApp)
        }
    }
    return if (response.isSuccessful && response.body() != null) {
        Result.success(response.body()!!)
    } else {
        Result.failure(ErrorApp.UnknownErrorApp)
    }
}