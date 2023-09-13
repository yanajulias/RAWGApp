package kompas.technical.test.data_source.usecase.local

import kompas.technical.test.data_source.repository.GameRepository
import kompas.technical.test.domain.usecase.local.FavoriteUseCase
import kompas.technical.test.frameworks.http.model.local.FavoriteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteUseCaseImpl @Inject constructor(
    private val gameRepository: GameRepository
) : FavoriteUseCase {

    override fun loadFavoriteList(): Flow<List<FavoriteEntity>> =
        gameRepository.loadGameFavoritesList()

    override fun addGameFavorites(favoriteEntity: FavoriteEntity): Boolean =
        gameRepository.addGameFavorites(favoriteEntity)

    override fun removeGameFavorites(favoriteEntity: FavoriteEntity): Boolean =
        gameRepository.removeGameFavorites(favoriteEntity)

    override fun isFavorite(gameId: Int): Boolean =
        gameRepository.isFavorite(gameId)

}