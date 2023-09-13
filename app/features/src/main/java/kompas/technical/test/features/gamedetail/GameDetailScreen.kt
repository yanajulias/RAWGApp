package kompas.technical.test.features.gamedetail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kompas.technical.test.features.gamedetail.components.GameDetailsHeader
import kompas.technical.test.features.gamedetail.components.GameDetailsSection
import kompas.technical.test.features.gamedetail.components.GameDetailsTopBar
import kotlinx.coroutines.launch

@Composable
fun GameDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    gameId: Int,
    viewModel: GameDetailsViewModel = hiltViewModel()
) {
    val scrollState: ScrollState = rememberScrollState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(gameId) {
        viewModel.getGameDetails(gameId = gameId)
        viewModel.isFavorite(gameId = gameId)
    }

    if (viewModel.state.value.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    } else {
        val gameDetails = remember { viewModel.state.value.gameDetails }
        val favoriteEntity = remember { viewModel.state.value.favoriteEntity }

        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },
            topBar = {
                GameDetailsTopBar(
                    navController = navController,
                    isFavorite = viewModel.state.value.isFavorite,
                    onChangeFavorite = { value ->
                        if (value) {
                            if (favoriteEntity != null) {
                                viewModel.addToFavorite(favoriteEntity = favoriteEntity)
                            }

                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = " Added to Favorites",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        } else {
                            if (favoriteEntity != null) {
                                viewModel.removeFromFavorite(favoriteEntity = favoriteEntity)
                            }
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "Removed from Favorites",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        }
                    }
                )
            },
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        ) { paddingValues ->
            Column(
                modifier = modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                if (gameDetails != null) {
                    GameDetailsHeader(gameDetails = gameDetails)
                }

                gameDetails?.genre?.joinToString(", ") { it.name }?.let {
                    Text(
                        modifier = modifier.padding(
                            horizontal = 14.dp, vertical = 2.dp
                        ),

                        text = "Genre: $it",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                gameDetails?.developers?.joinToString(", ") { it.name }?.let {
                    Text(
                        modifier = modifier.padding(
                            horizontal = 14.dp, vertical = 2.dp
                        ),

                        text = "Developer: $it",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        ),
                        maxLines = 10,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                GameDetailsSection(title = "Description")

                if (gameDetails?.description?.isEmpty() == true) {
                    Text(
                        modifier = modifier.padding(start = 16.dp, top = 8.dp, bottom = 12.dp),
                        text = "No Description",
                    )
                } else {
                    if (gameDetails != null) {
                        Text(
                            modifier = Modifier.padding(
                                horizontal = 16.dp,
                                vertical = 8.dp
                            ),
                            text = gameDetails.description,
                        )
                    }
                }
                Spacer(modifier = modifier.height(28.dp))
            }
        }
    }

}