package kompas.technical.test.domain.usecase.remote

import androidx.paging.PagingData
import kompas.technical.test.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameUseCase {
    fun loadGameList(): Flow<PagingData<Game>>
}