package com.alfsuace.superheroestfg.app.presentation.views

import android.content.Context
import com.alfsuace.superheroestfg.R


interface ErrorAppUI {

    fun getImageError(): Int

    fun getTitleError(): String

    fun getDescriptionError(): String

    fun getActionRetry(): Unit
}

class ServerErrorAppUI(val context: Context) : ErrorAppUI {

    override fun getImageError(): Int {
        return R.drawable.ic_error_server
    }

    override fun getTitleError(): String {
        return context.getString(R.string.title_error_server)
    }

    override fun getDescriptionError(): String {
        return context.getString(R.string.description_error_server)
    }

    override fun getActionRetry() {
        TODO("Not yet implemented")
    }

}

class ConnectionErrorAppUI(val context: Context) : ErrorAppUI {

    override fun getImageError(): Int {
        return R.drawable.ic_error_internet
    }

    override fun getTitleError(): String {
        return context.getString(R.string.title_error_connection)
    }

    override fun getDescriptionError(): String {
        return context.getString(R.string.description_error_connection)
    }

    override fun getActionRetry() {
        TODO("Not yet implemented")
    }

}

class UnknownErrorAppUI(val context: Context) : ErrorAppUI {

    override fun getImageError(): Int {
        return R.drawable.ic_error_unknown
    }

    override fun getTitleError(): String {
        return context.getString(R.string.title_error_unknown)
    }

    override fun getDescriptionError(): String {
        return context.getString(R.string.description_error_unknown)
    }

    override fun getActionRetry() {
        TODO("Not yet implemented")
    }

}
