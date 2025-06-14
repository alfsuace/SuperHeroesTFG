package com.alfsuace.superheroestfg.app.presentation.views

import android.content.Context
import com.alfsuace.superheroestfg.app.domain.ErrorApp

class ErrorAppUIFactory(private val context: Context) {

    fun build(errorApp: ErrorApp): ErrorAppUI {
        return when (errorApp) {
            ErrorApp.InternetErrorApp -> ConnectionErrorAppUI(context)
            ErrorApp.UnknownErrorApp -> UnknownErrorAppUI(context)
            ErrorApp.DataErrorApp -> ServerErrorAppUI(context)
            ErrorApp.ServerErrorApp -> ServerErrorAppUI(context)
            ErrorApp.CacheExpiredErrorApp -> ServerErrorAppUI(context)
        }
    }
}