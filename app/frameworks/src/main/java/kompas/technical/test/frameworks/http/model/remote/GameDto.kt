package kompas.technical.test.frameworks.http.model.remote

import com.google.gson.annotations.SerializedName

data class GameDto(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: List<ResultDto>? = null,
) {

    data class ResultDto(
        @SerializedName("genres")
        val genres: List<GenreDto>? = null,
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("background_image")
        val backgroundImage: String? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("released")
        val released: String? = null
    )
}