package kompas.technical.test.frameworks.http.model.local

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kompas.technical.test.frameworks.http.model.remote.DeveloperDto
import kompas.technical.test.frameworks.http.model.remote.GenreDto

data class FavoriteEntity (
    @PrimaryKey
    val id: Int,
    @ColumnInfo
    val backgroundImage: String? = null,
    @ColumnInfo
    val descriptionRaw: String? = null,
    @ColumnInfo
    val developers: List<DeveloperDto>? = null,
    @ColumnInfo
    val genres: List<GenreDto>? = null,
    @ColumnInfo
    val name: String? = null,
    @ColumnInfo
    val released: String? = null,
)