package com.alfsuace.superheroestfg.feature.superhero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfsuace.superheroestfg.app.data.domain.ErrorApp
import com.alfsuace.superheroestfg.feature.superhero.domain.DeleteFavoriteSuperHeroUseCase
import com.alfsuace.superheroestfg.feature.superhero.domain.GetFavoritesSuperHeroesUseCase
import com.alfsuace.superheroestfg.feature.superhero.domain.GetSuperHeroesUseCase
import com.alfsuace.superheroestfg.feature.superhero.domain.SaveFavoriteSuperHeroUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SuperHeroViewModel(
    private val getSuperHeroesUseCase: GetSuperHeroesUseCase,
    private val getFavoritesSuperHeroesUseCase: GetFavoritesSuperHeroesUseCase,
    private val saveFavoriteSuperHeroUseCase: SaveFavoriteSuperHeroUseCase,
    private val deleteFavoriteSuperHeroUseCase: DeleteFavoriteSuperHeroUseCase
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

    fun getFavoriteSuperHeroes() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val superHeroes = getFavoritesSuperHeroesUseCase.invoke()
            _uiState.postValue(UiState(superHeroes = superHeroes))
        }
    }

    fun saveFavoriteSuperHero(superHeroId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveFavoriteSuperHeroUseCase.invoke(superHeroId)
        }
    }

    fun deleteFavoriteSuperHero(superHeroId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteFavoriteSuperHeroUseCase.invoke(superHeroId)
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superHeroes: List<GetSuperHeroesUseCase.SuperHeroUiModel> = emptyList()
    )
}