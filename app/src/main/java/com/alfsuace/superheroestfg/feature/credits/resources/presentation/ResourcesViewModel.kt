package com.alfsuace.superheroestfg.feature.credits.resources.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfsuace.superheroestfg.app.domain.ErrorApp
import com.alfsuace.superheroestfg.feature.credits.resources.domain.GetResourcesUseCase
import com.alfsuace.superheroestfg.feature.credits.resources.domain.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ResourcesViewModel(
    private val getResourcesUseCase: GetResourcesUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun getResources() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getResourcesUseCase.invoke().fold(
                onSuccess = { resources ->
                    _uiState.postValue(
                        UiState(isLoading = false, resources = resources)
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
        val resources: List<Resource> = emptyList()
    )
}