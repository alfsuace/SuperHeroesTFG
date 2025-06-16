package com.alfsuace.superheroestfg.feature.credits.developer.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfsuace.superheroestfg.app.domain.ErrorApp
import com.alfsuace.superheroestfg.feature.credits.developer.domain.Developer
import com.alfsuace.superheroestfg.feature.credits.developer.domain.GetDeveloperUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class DeveloperViewModel(private val getDeveloperUseCase: GetDeveloperUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState


    fun getDeveloper() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getDeveloperUseCase.invoke().fold(
                onSuccess = { developer ->
                    _uiState.postValue(
                        UiState(isLoading = false, resources = developer)
                    )
                },
                onFailure = { error ->
                    _uiState.postValue(
                        UiState(isLoading = false, errorApp = error as? ErrorApp)
                    )
                }
            )
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val resources: Developer? = null
    )
}