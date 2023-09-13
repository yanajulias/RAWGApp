package kompas.technical.test.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import kompas.technical.test.domain.model.Game
import kompas.technical.test.features.components.BottomBarNavigation
import kompas.technical.test.features.components.CustomTopBar
import kompas.technical.test.features.components.NoConnectionScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val allGameList: LazyPagingItems<Game> =
        homeViewModel.state.value.allGameList.collectAsLazyPagingItems()

    val pullRefreshState =
        rememberPullRefreshState(refreshing = false, onRefresh = allGameList::refresh)

    val shouldShowErrorScreen = allGameList.loadState.refresh is LoadState.Error

    Scaffold(topBar = {
        Column(modifier = modifier) {
            CustomTopBar("Games For You")
        }
    }, bottomBar = { BottomBarNavigation(navController = navController) }) { paddingValues ->
        Box(
            modifier = Modifier.pullRefresh(pullRefreshState),
            contentAlignment = Alignment.TopCenter
        ) {

            when {
                shouldShowErrorScreen -> {
                    NoConnectionScreen(onTryAgain = allGameList::refresh)
                }

                else -> {

                    when (allGameList.itemCount) {
                        0 -> {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = modifier
                                    .fillMaxSize()
                                    .pullRefresh(pullRefreshState)
                            ) {
                                CircularProgressIndicator()
                            }
                        }

                        else -> {
                            CircularProgressIndicator()
                            LazyColumn(
                                modifier = modifier
                                    .padding(paddingValues)
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                state = homeViewModel.lazyListState
                            ) {

                                gameListWithPagination(
                                    listWithPagination = allGameList,
                                    navController = navController
                                )
                            }
                            PullRefreshIndicator(
                                refreshing = false,
                                state = pullRefreshState,
                                contentColor = MaterialTheme.colors.onSurface
                            )
                        }
                    }
                }
            }
        }

    }
}
