package kompas.technical.test.features.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kompas.technical.test.domain.mapper.toGameFavorites
import kompas.technical.test.features.R
import kompas.technical.test.features.components.BottomBarNavigation
import kompas.technical.test.features.components.CardItem
import kompas.technical.test.features.components.CustomTopBar
import kompas.technical.test.features.ui.theme.RAWGAppTheme

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val listState = rememberLazyListState()

    Scaffold(
        topBar = { CustomTopBar("Favorites") },
        bottomBar = { BottomBarNavigation(navController = navController) }
    ) { paddingValues ->
        if (viewModel.state.value.isLoading) {
            Box(modifier = modifier.padding(paddingValues)) {
                CircularProgressIndicator()
            }
        } else {
            if (viewModel.state.value.favorites.isEmpty()) {
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
                            painter = painterResource(id = R.drawable.ic_favorites),
                            contentDescription = "Favorites"
                        )

                        Text(
                            text = "Favorites is Empty!",
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
            } else {
                LazyColumn(
                    state = listState,
                    modifier = modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                ) {
                    items(viewModel.state.value.favorites.size) {
                        CardItem(
                            navController = navController,
                            gameList = viewModel.state.value.favorites[it].toGameFavorites()
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    RAWGAppTheme {
        FavoriteScreen(navController = rememberNavController())
    }
}