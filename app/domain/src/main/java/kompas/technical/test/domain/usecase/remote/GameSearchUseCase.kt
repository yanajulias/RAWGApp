package kompas.technical.test.domain.usecase.remote

import kompas.technical.test.common.DataResult
import kompas.technical.test.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameSearchUseCase {
    fun loadGameSearchList(query: String): Flow<DataResult<List<Game>>>
}