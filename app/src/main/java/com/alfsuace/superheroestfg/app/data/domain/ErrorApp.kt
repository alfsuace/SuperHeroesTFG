package com.alfsuace.superheroestfg.app.data.domain

sealed class ErrorApp {
    object InternetErrorApp : ErrorApp()
    object ServerErrorApp : ErrorApp()
    object DataErrorApp : ErrorApp()

    object UnknownErrorApp : ErrorApp()

}