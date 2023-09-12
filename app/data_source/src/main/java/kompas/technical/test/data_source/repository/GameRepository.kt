package kompas.technical.test.data_source.repository

import androidx.paging.PagingData
import kompas.technical.test.domain.model.Game
import kompas.technical.test.domain.model.GameQuery
import kompas.technical.test.frameworks.http.model.remote.GameDetailDto
import kompas.technical.test.frameworks.http.model.remote.GameDto
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    suspend fun getSearchGameList(gameQuery: GameQuery): GameDto

    fun getAllGameList(): Flow<PagingData<Game>>

    suspend fun getGameDetails(gameId: Int): GameDetailDto

    fun loadGameFavoritesList(): Flow<List<GameDetailDto>>

    fun addGameFavorites(gameDetailDto: GameDetailDto): Boolean

    fun removeGameFavorites(gameDetailDto: GameDetailDto): Boolean

    fun isFavorite(gameId: Int): Boolean
}