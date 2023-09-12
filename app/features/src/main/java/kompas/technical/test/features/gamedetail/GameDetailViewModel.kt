package kompas.technical.test.features.gamedetail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kompas.technical.test.common.DataResult
import kompas.technical.test.domain.usecase.local.FavoriteUseCase
import kompas.technical.test.domain.usecase.remote.GameDetailUseCase
import kompas.technical.test.frameworks.http.model.remote.GameDetailDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GameDetailsViewModel @Inject constructor(
    private val gameDetailUseCase: GameDetailUseCase,
    private val favoriteUseCase: FavoriteUseCase,
) : ViewModel() {

    private val _state: MutableState<GameDetailsState> = mutableStateOf(GameDetailsState())
    val state: State<GameDetailsState> = _state

//    private val _favoriteState: MutableState<FavoriteEntity> =
//        mutableStateOf(FavoriteEntity)
//    val favoriteState: State<GameDetailsFavoriteState> = _favoriteState

    fun getGameDetails(gameId: Int) {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    gameDetailUseCase.loadGameDetail(gameId = gameId)
                }

                result.collect {
                    when (it) {
                        is DataResult.Success -> {
                            _state.value = _state.value.copy(
                                isLoading = false,
                                gameDetails = it.value,
                            )
                        }

                        is DataResult.Failure -> {
                            _state.value = GameDetailsState(
                                error = it.message ?: "An unexpected error occurred",
                                isLoading = false
                            )
                        }

                        is DataResult.Loading -> {
                            _state.value = _state.value.copy(isLoading = true)
                        }
                    }
                }


            } catch (e: Exception) {
                _state.value = GameDetailsState(
                    error = e.message ?: "An unexpected error occurred",
                    isLoading = false
                )
            }
        }
    }

    fun isFavorite(gameId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = favoriteUseCase.isFavorite(gameId = gameId)
            _state.value = _state.value.copy(isFavorite = result)
        }
    }

    fun addToFavorite(gameDetailDto: GameDetailDto) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteUseCase.addGameFavorites(gameDetailDto)
            _state.value = _state.value.copy(isFavorite = true)
        }
    }

    fun removeFromFavorite(gameDetailDto: GameDetailDto) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteUseCase.removeGameFavorites(gameDetailDto)
            _state.value = _state.value.copy(isFavorite = true)
        }
    }

}