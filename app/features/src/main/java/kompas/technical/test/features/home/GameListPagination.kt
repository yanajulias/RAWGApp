package kompas.technical.test.features.home

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import kompas.technical.test.domain.model.Game
import kompas.technical.test.features.components.CardItem
import kompas.technical.test.features.components.CardItemShimmer

fun LazyListScope.gameListWithoutPagination(
    modifier: Modifier = Modifier,
    navController: NavController,
    list: List<Game>
) {
    items(list.size) { index ->
        CardItem(
            gameList = list[index],
            navController = navController
        )
    }
}

fun LazyListScope.gameListWithPagination(
    listWithPagination: LazyPagingItems<Game>,
    navController: NavController
) {
    items(listWithPagination.itemCount) { i: Int ->
        listWithPagination[i]?.let {
            CardItem(
                gameList = it,
                navController = navController
            )
        }
    }

    item {
        when (val state = listWithPagination.loadState.refresh) {
            is LoadState.Loading -> {
                (0..10).forEach { _ ->
                    CardItemShimmer()
                }
            }

            is LoadState.Error -> {
                Text(text = "Error : ${state.error.localizedMessage}")
            }

            else -> {}
        }
    }
}