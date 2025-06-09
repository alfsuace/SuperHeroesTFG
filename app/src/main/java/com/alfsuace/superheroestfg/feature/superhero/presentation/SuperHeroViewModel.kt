package com.alfsuace.superheroestfg.feature.superhero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfsuace.superheroestfg.app.data.domain.ErrorApp
import com.alfsuace.superheroestfg.feature.superhero.domain.GetSuperHeroByIdUseCase
import com.alfsuace.superheroestfg.feature.superhero.domain.GetSuperHeroesUseCase
import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SuperHeroViewModel(
    private val getSuperHeroesUseCase: GetSuperHeroesUseCase,
    private val getSuperHeroByIdUseCase: GetSuperHeroByIdUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState


    fun getSuperHeroes() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val superHeroes = getSuperHeroesUseCase.invoke()
            _uiState.postValue(UiState(superHeroes = superHeroes))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superHeroes: List<SuperHero> = emptyList()
    )
}