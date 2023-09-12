package kompas.technical.test.features.favorites

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kompas.technical.test.domain.usecase.local.FavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteUseCase: FavoriteUseCase
): ViewModel() {

    private val _state: MutableState<FavoriteState> = mutableStateOf(FavoriteState())
    val state: State<FavoriteState> = _state

    init {
        getFavoritesList()
    }

    private fun getFavoritesList() {
        viewModelScope.launch {
            try {
                _state.value = FavoriteState(isLoading = true)
                val result = withContext(Dispatchers.IO) {
                    favoriteUseCase.loadFavoriteList()
                }
                result.collect {
                    _state.value = FavoriteState(favorites = it)
                }
            } catch (e: Exception) {
                _state.value = FavoriteState(error = e.message ?: "Unknown Error")
            }
        }
    }

}