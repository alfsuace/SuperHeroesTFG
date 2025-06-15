package com.alfsuace.superheroestfg.feature.superhero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfsuace.superheroestfg.app.domain.ErrorApp
import com.alfsuace.superheroestfg.feature.superhero.domain.GetSuperHeroByIdUseCase
import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SuperHeroDetailViewModel(
    private val getSuperHeroByIdUseCase: GetSuperHeroByIdUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState


    fun getSuperHeroById(id: String) {
        _uiState.value = UiState(isLoading = true)

        viewModelScope.launch(Dispatchers.IO) {
            getSuperHeroByIdUseCase.invoke(id).fold(
                onSuccess = { hero ->
                    _uiState.postValue(UiState(isLoading = false, superHero = hero))
                },
                onFailure = { error ->
                    _uiState.postValue(UiState(isLoading = false, errorApp = error as? ErrorApp))
                }
            )
        }
    }


    data class UiState(
        val isLoading: Boolean = false,
        val superHero: SuperHero? = null,
        val errorApp: ErrorApp? = null
    )
}