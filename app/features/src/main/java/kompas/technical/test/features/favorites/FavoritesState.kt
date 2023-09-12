package kompas.technical.test.features.favorites

import kompas.technical.test.frameworks.http.model.remote.GameDetailDto

data class FavoriteState(
    val isLoading: Boolean = false,
    val favorites: List<GameDetailDto> = emptyList(),
    val error: String = "",
    val isFavorite: Boolean = false,
)