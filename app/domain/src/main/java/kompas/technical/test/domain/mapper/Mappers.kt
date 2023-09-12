package kompas.technical.test.domain.mapper

import kompas.technical.test.domain.model.Developers
import kompas.technical.test.domain.model.Game
import kompas.technical.test.domain.model.GameDetail
import kompas.technical.test.domain.model.Genre
import kompas.technical.test.frameworks.http.model.DeveloperDto
import kompas.technical.test.frameworks.http.model.GameDetailDto
import kompas.technical.test.frameworks.http.model.GameDto
import kompas.technical.test.frameworks.http.model.GenreDto


fun GameDto.ResultDto?.toGame() = Game(
    id = this?.id ?: 0,
    name = this?.name.orEmpty(),
    backgroundImage = this?.backgroundImage.orEmpty(),
    released = this?.released.orEmpty(),
    genres = this?.genres.orEmpty().map { it.toGenre() }
)

fun GameDto.toGameList(): List<Game> =
    results.orEmpty().map { it.toGame() }


fun GenreDto.toGenre() = Genre(
    id = this.id ?: 0,
    name = this.name.orEmpty()
)

fun GameDetailDto.toGameDetail() = GameDetail(
    id = this.id,
    name = this.name.orEmpty(),
    backgroundImage = this.backgroundImage.orEmpty(),
    description = this.descriptionRaw.orEmpty(),
    developers = this.developers.orEmpty().map { it.toDeveloper() },
    genre = this.genres.orEmpty().map { it.toGenre() },
    released = this.released.orEmpty()
)

fun DeveloperDto.toDeveloper() = Developers(
    id = this.id ?: 0,
    name = this.name.orEmpty()
)

fun GameDetailDto.toGameFavorites() = GameDetail (
    id = id,
    name = this.name.orEmpty(),
    backgroundImage = this.backgroundImage.orEmpty(),
    description = this.descriptionRaw.orEmpty(),
    developers = this.developers.orEmpty().map { it.toDeveloper() },
    genre = this.genres.orEmpty().map { it.toGenre() },
    released = this.released.orEmpty(),
)


