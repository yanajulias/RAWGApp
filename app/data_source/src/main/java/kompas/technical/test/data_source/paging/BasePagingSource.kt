package kompas.technical.test.data_source.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kompas.technical.test.domain.mapper.toGameList
import kompas.technical.test.domain.model.Game
import kompas.technical.test.frameworks.GameApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BasePagingSource @Inject constructor(
    private val gameApiService: GameApiService
) : PagingSource<Int, Game>() {

    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        return try {
            val nextPage = params.key ?: 1
            val response = withContext(Dispatchers.IO) {
                gameApiService.getGameList(
                    page = nextPage,
                    pageSize = 10
                )
            }
            val gameList: List<Game> = response.toGameList()
            LoadResult.Page(
                data = gameList,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (gameList.isEmpty()) null else nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
