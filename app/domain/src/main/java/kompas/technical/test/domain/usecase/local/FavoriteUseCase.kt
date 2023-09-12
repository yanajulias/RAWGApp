package kompas.technical.test.domain.usecase.local

import kompas.technical.test.frameworks.http.model.remote.GameDetailDto
import kotlinx.coroutines.flow.Flow

interface FavoriteUseCase {
    fun loadFavoriteList(): Flow<List<GameDetailDto>>

    fun addGameFavorites(gameDetailDto: GameDetailDto): Boolean

    fun removeGameFavorites(gameDetailDto: GameDetailDto): Boolean

    fun isFavorite(gameId: Int): Boolean
}