package kompas.technical.test.domain.usecase.local

import kompas.technical.test.frameworks.http.model.local.FavoriteEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteUseCase {
    fun loadFavoriteList(): Flow<List<FavoriteEntity>>

    fun addGameFavorites(favoriteEntity: FavoriteEntity): Boolean

    fun removeGameFavorites(favoriteEntity: FavoriteEntity): Boolean

    fun isFavorite(gameId: Int): Boolean
}