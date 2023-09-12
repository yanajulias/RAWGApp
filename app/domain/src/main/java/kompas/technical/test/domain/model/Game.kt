package kompas.technical.test.domain.model

data class Game(
    val id: Int,
    val name: String,
    val backgroundImage: String,
    val genres: List<Genre>,
    val released: String,
)