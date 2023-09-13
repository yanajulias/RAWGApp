package kompas.technical.test.features.favorites

import kompas.technical.test.frameworks.http.model.local.FavoriteEntity

data class FavoriteState(
    val isLoading: Boolean = false,
    val favorites: List<FavoriteEntity> = emptyList(),
    val error: String = "",
    val isFavorite: Boolean = false,
)