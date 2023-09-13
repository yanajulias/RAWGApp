package kompas.technical.test.features.gamedetail.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kompas.technical.test.features.ui.theme.RAWGAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailsTopBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    isFavorite: Boolean = false,
    onChangeFavorite: (Boolean) -> Unit = {}
) {
    var isFavoriteState by remember { mutableStateOf(isFavorite) }

    TopAppBar(
        title = {},
        modifier = modifier,
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        ),
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onTertiaryContainer,
                )
            }
        },
        actions = {
            if (isFavoriteState) {
                Button(
                    modifier = modifier
                        .padding(
                            end = 16.dp
                        )
                        .animateContentSize(),
                    onClick = {
                        onChangeFavorite(false)
                        isFavoriteState = false
                    },
                    contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError
                    )
                ) {
                    Icon(
                        Icons.Outlined.Favorite,
                        contentDescription = "Add to Favorites",
                        modifier = modifier.size(ButtonDefaults.IconSize),
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Remove Favorites")
                }
            } else {
                Button(
                    modifier = modifier
                        .padding(
                            end = 16.dp
                        )
                        .animateContentSize(),
                    onClick = {
                        onChangeFavorite(true)
                        isFavoriteState = true
                    },
                    contentPadding = ButtonDefaults.ButtonWithIconContentPadding
                ) {
                    Icon(
                        Icons.Rounded.Favorite,
                        contentDescription = "Add to Favorites",
                        modifier = modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Favorites")
                }
            }
        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    )
}

@Preview(showBackground = true)
@Composable
fun GameDetailsTopBarPreview() {
    RAWGAppTheme {
        GameDetailsTopBar(navController = rememberNavController())
    }
}

