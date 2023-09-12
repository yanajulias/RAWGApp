package kompas.technical.test.data_source.usecase.remote

import kompas.technical.test.common.DataResult
import kompas.technical.test.data_source.repository.GameRepository
import kompas.technical.test.domain.mapper.toGameDetail
import kompas.technical.test.domain.model.GameDetail
import kompas.technical.test.domain.usecase.remote.GameDetailUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GameDetailUseCaseImpl @Inject constructor(
    private val gameRepository: GameRepository
) : GameDetailUseCase {

    override fun loadGameDetail(gameId: Int): Flow<DataResult<GameDetail>> = flow {
        try {
            emit(DataResult.Loading())
            val gameDetails: GameDetail =
                gameRepository.getGameDetails(gameId = gameId).toGameDetail()

            emit(DataResult.Success(gameDetails))
        } catch (e: HttpException) {
            emit(DataResult.Failure(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(DataResult.Failure("Couldn't reach server. Check your internet connection."))
        }
    }
}