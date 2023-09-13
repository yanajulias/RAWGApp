package kompas.technical.test.frameworks.http.model.remote

import com.google.gson.annotations.SerializedName

data class GameDetailDto(
    @SerializedName("background_image")
    val backgroundImage: String? = null,
    @SerializedName("description_raw")
    val descriptionRaw: String? = null,
    @SerializedName("developers")
    val developers: List<DeveloperDto>? = null,
    @SerializedName("genres")
    val genres: List<GenreDto>? = null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("released")
    val released: String? = null,
)
