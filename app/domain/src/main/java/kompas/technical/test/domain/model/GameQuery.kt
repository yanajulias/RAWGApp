package kompas.technical.test.domain.model

data class GameQuery(
    val page: Int? = null,
    val pageSize: Int? = null,
    val search: String? = null,
    val parentPlatforms: String? = null,
    val genres: String? = null,
    val platforms: String? = null,
    val stores: String? = null,
    val developers: String? = null,
    val publishers: String? = null,
    val tags: String? = null,
    val dates: String? = null,
)