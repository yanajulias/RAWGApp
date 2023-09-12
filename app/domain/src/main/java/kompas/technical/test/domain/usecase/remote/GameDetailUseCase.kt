package kompas.technical.test.domain.usecase.remote

import kompas.technical.test.common.DataResult
import kompas.technical.test.domain.model.GameDetail
import kotlinx.coroutines.flow.Flow

interface GameDetailUseCase {
    fun loadGameDetail(gameId: Int): Flow<DataResult<GameDetail>>
}