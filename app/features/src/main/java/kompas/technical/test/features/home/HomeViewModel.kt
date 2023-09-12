package kompas.technical.test.features.home

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kompas.technical.test.domain.model.Game
import kompas.technical.test.domain.usecase.remote.GameUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val gameUseCase: GameUseCase
) : ViewModel() {
    private val _state: MutableState<HomeState> = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    val lazyListState: LazyListState = LazyListState()

    init {
        _state.value = _state.value.copy(
            allGameList = getAllGameListWithPagination()
        )
    }

    private fun getAllGameListWithPagination(): Flow<PagingData<Game>> {
        return gameUseCase.loadGameList()
            .cachedIn(viewModelScope)
    }
}