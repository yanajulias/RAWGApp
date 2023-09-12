package kompas.technical.test.frameworks

import kompas.technical.test.common.Constants
import kompas.technical.test.frameworks.http.model.remote.GameDetailDto
import kompas.technical.test.frameworks.http.model.remote.GameDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameApiService {

    @GET(Constants.GET_GAME)
    suspend fun getGameList(
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize:Int? = null,
        @Query("search") search: String? = null,
        @Query("parent_platforms") parentPlatforms: String? = null,
        @Query("genres") genres: String? = null,
        @Query("platforms") platforms: String? = null,
        @Query("stores") stores: String? = null,
        @Query("developers") developers: String? = null,
        @Query("publishers") publishers: String? = null,
        @Query("tags") tags: String? = null,
        @Query("dates") dates: String? = null,
    ): GameDto

    @GET(Constants.GET_GAME_DETAIL)
    suspend fun getGameDetail(@Path("id") id: Int): GameDetailDto
}