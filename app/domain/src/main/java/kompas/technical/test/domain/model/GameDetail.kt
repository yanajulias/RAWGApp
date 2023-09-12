package kompas.technical.test.domain.model

data class GameDetail(
    val id: Int,
    val name: String,
    val backgroundImage: String,
    val description: String,
    val developers: List<Developers>,
    val genre: List<Genre>,
    val released: String,
)