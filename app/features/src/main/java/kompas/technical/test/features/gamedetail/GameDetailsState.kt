package kompas.technical.test.features.gamedetail

import kompas.technical.test.domain.model.GameDetail
import kompas.technical.test.domain.model.Genre
import kompas.technical.test.frameworks.http.model.remote.GameDetailDto

data class GameDetailsState(
    val isLoading: Boolean = false,
    val gameDetails: GameDetail? = null,
    val error: String? = null,
    val isFavorite: Boolean = false,
    val genreDetails: List<Genre>? = null,
    val gameDetailDto: GameDetailDto? = null
)