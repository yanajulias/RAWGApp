package kompas.technical.test.features.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kompas.technical.test.common.DataResult
import kompas.technical.test.domain.usecase.remote.GameSearchUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private  val gameSearchUseCase: GameSearchUseCase
) : ViewModel() {
    private val _state: MutableState<SearchState> = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    fun getSearchResult(query: String) {
        _state.value = _state.value.copy(isSearched = true)

        gameSearchUseCase.loadGameSearchList(query).onEach { resource ->
            when (resource) {
                is DataResult.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        searchResults = resource.value ?: listOf()
                    )
                }

                is DataResult.Failure -> {
                    _state.value = SearchState(
                        error = resource.message ?: "An unexpected error occurred",
                        isLoading = false
                    )
                }

                is DataResult.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}