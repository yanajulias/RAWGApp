package kompas.technical.test.data_source.usecase.local

import kompas.technical.test.data_source.repository.GameRepository
import kompas.technical.test.domain.usecase.local.FavoriteUseCase
import kompas.technical.test.frameworks.http.model.remote.GameDetailDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteUseCaseImpl @Inject constructor(
    private val gameRepository: GameRepository
) : FavoriteUseCase {

    override fun loadFavoriteList(): Flow<List<GameDetailDto>> =
        gameRepository.loadGameFavoritesList()

    override fun addGameFavorites(gameDetailDto: GameDetailDto): Boolean =
        gameRepository.addGameFavorites(gameDetailDto)

    override fun removeGameFavorites(gameDetailDto: GameDetailDto): Boolean =
        gameRepository.removeGameFavorites(gameDetailDto)

    override fun isFavorite(gameId: Int): Boolean =
        gameRepository.isFavorite(gameId)

}