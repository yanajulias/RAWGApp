package kompas.technical.test.frameworks.http.model.local

import androidx.room.Entity

import kompas.technical.test.frameworks.http.model.remote.GenreDto

@Entity(
    tableName = "favorites_table",
    primaryKeys = ["id"]
)
data class FavoriteEntity (
    val id: Int,
    val name: String? = null,
    val backgroundImage: String? = null,
    val genres: List<GenreDto>? = null,
    val released: String? = null
) {
//    fun toFavoriteEntity(): Game {
//
//    }
}