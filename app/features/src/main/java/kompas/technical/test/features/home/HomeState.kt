package kompas.technical.test.features.home

import androidx.paging.PagingData
import kompas.technical.test.domain.model.Game
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class HomeState(
    val searchBoxIsClicked: Boolean = false,
    val allGameList: Flow<PagingData<Game>> = flow { },
)