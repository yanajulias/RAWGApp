package kompas.technical.test.features.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kompas.technical.test.features.R
import kompas.technical.test.features.components.BottomBarNavigation
import kompas.technical.test.features.components.CustomTopBar
import kompas.technical.test.features.components.SearchBar
import kompas.technical.test.features.home.gameListWithoutPagination

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val state: SearchState = viewModel.state.value

    val lazyListState = rememberLazyListState()

    Scaffold(
        topBar = {
            Column(modifier = modifier) {
                CustomTopBar("Search")
                SearchBar(onSearch = { viewModel.getSearchResult(it) })
            }
        },
        bottomBar = { BottomBarNavigation(navController = navController) }
    ) { paddingValues ->


        if (state.searchResults.isEmpty() && state.isSearched && !state.isLoading) {
            Box(
                modifier = modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No results found!",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleSmall.copy(
                        color = MaterialTheme.colorScheme.secondary.copy(
                            alpha = 0.8f
                        ),
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }

        if (!state.isSearched && state.searchResults.isEmpty()) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier.clipToBounds(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = modifier
                                .height(100.dp)
                                .width(100.dp),
                            painter = painterResource(id = R.drawable.ic_empty_list),
                            contentDescription = "Search Games"
                        )

                        Text(
                            text = "Search for some Games!",
                            modifier = Modifier.padding(top = 16.dp),
                            style = MaterialTheme.typography.titleLarge.copy(
                                color = MaterialTheme.colorScheme.secondary.copy(
                                    alpha = 0.8f
                                ),
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }

            }
        }

        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        if (state.searchResults.isNotEmpty()) {
            LazyColumn(
                modifier = modifier.padding(paddingValues),
                state = lazyListState
            ) {
                gameListWithoutPagination(
                    modifier = modifier.padding(4.dp),
                    list = state.searchResults,
                    navController = navController
                )
            }
        }
    }
}