package kompas.technical.test.data_source.usecase.remote

import androidx.paging.PagingData
import kompas.technical.test.data_source.repository.GameRepository
import kompas.technical.test.domain.model.Game
import kompas.technical.test.domain.usecase.remote.GameUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameUseCaseImpl @Inject constructor(
    private val gameRepository: GameRepository
) : GameUseCase {

    override fun loadGameList(): Flow<PagingData<Game>> = gameRepository.getAllGameList()
}