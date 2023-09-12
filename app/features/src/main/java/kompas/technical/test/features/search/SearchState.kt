package kompas.technical.test.features.search

import kompas.technical.test.domain.model.Game

data class SearchState(
    val isLoading: Boolean = false,
    val isSearched: Boolean = false,
    val error: String? = null,
    val searchResults: List<Game> = emptyList(),
)
