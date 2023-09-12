package kompas.technical.test.frameworks.http.model.remote

import com.google.gson.annotations.SerializedName

data class DeveloperDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
)