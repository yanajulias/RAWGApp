package kompas.technical.test.data_source.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kompas.technical.test.data_source.paging.BasePagingSource
import kompas.technical.test.domain.model.Game
import kompas.technical.test.domain.model.GameQuery
import kompas.technical.test.frameworks.GameApiService
import kompas.technical.test.frameworks.database.FavoriteDao
import kompas.technical.test.frameworks.http.model.remote.GameDetailDto
import kompas.technical.test.frameworks.http.model.remote.GameDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val gameApiService: GameApiService,
    private val favoriteDao: FavoriteDao
) : GameRepository {
    override suspend fun getSearchGameList(gameQuery: GameQuery): GameDto =
        gameApiService.getGameList(
            page = gameQuery.page,
            pageSize = gameQuery.pageSize,
            search = gameQuery.search,
            parentPlatforms = gameQuery.parentPlatforms,
            genres = gameQuery.genres,
            platforms = gameQuery.platforms,
            stores = gameQuery.stores,
            developers = gameQuery.developers,
            publishers = gameQuery.publishers,
            tags = gameQuery.tags,
            dates = gameQuery.dates,
        )

    override fun getAllGameList(): Flow<PagingData<Game>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                BasePagingSource(gameApiService)
            }
        ).flow
    }

    override suspend fun getGameDetails(gameId: Int): GameDetailDto =
        gameApiService.getGameDetail(gameId)

    override fun loadGameFavoritesList(): Flow<List<GameDetailDto>> = favoriteDao.getFavoriteList()

    override fun addGameFavorites(gameDetailDto: GameDetailDto): Boolean {
        val effected = favoriteDao.addToFavoriteList(gameDetailDto)
        return effected > 0
    }

    override fun removeGameFavorites(gameDetailDto: GameDetailDto): Boolean {
        val effected = favoriteDao.removeFavoriteList(gameDetailDto.id)
        return effected > 0
    }

    override fun isFavorite(gameId: Int): Boolean = favoriteDao.isFavorite(gameId)
}

