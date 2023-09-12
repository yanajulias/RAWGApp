package kompas.technical.test.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import kompas.technical.test.domain.model.Game
import kompas.technical.test.features.components.BottomBarNavigation
import kompas.technical.test.features.components.CustomTopBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val allGameList: LazyPagingItems<Game> = homeViewModel
        .state.value.allGameList
        .collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            Column(modifier = modifier) {
                CustomTopBar("Games For You")
            }
        },
        bottomBar = { BottomBarNavigation(navController = navController) }
    ) { paddingValues ->


        when (allGameList.itemCount) {
            0 -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }

            else -> {
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

                    item {
                        Box(
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
