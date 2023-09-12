package kompas.technical.test.data_source.usecase.remote

import kompas.technical.test.common.DataResult
import kompas.technical.test.data_source.repository.GameRepository
import kompas.technical.test.domain.mapper.toGameList
import kompas.technical.test.domain.model.Game
import kompas.technical.test.domain.model.GameQuery
import kompas.technical.test.domain.usecase.remote.GameSearchUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GameSearchUseCaseImpl @Inject constructor(
    private val gameRepository: GameRepository
) : GameSearchUseCase {
    override fun loadGameSearchList(query: String): Flow<DataResult<List<Game>>> = flow {
        try {
            emit(DataResult.Loading())

            val list: List<Game> = gameRepository
                .getSearchGameList(
                    gameQuery = GameQuery(
                        page = 1,
                        pageSize = 10,
                        search = query
                    )
                ).toGameList()
            emit(DataResult.Success(list))
        } catch (e: HttpException) {
            emit(DataResult.Failure(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(DataResult.Failure("Couldn't reach server. Check your internet connection."))
        }
    }
}