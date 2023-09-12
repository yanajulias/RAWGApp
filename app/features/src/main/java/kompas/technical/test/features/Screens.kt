package kompas.technical.test.features

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screens(
    val route: String,
    val arguments: List<NamedNavArgument>? = null
) {
    object GameDetailsScreen : Screens(
        route = "game/details",
        arguments = listOf(
            navArgument("gameId") {
                type = NavType.IntType
            }
        )
    )

    sealed class BottomBarNavigationScreens(
        route: String,
        val title: String,
        val icon: ImageVector? = null
    ) : Screens(route) {

        object Home : BottomBarNavigationScreens(
            route = "home",
            title = "Home",
            icon = Icons.Filled.Home
        )

        object Search : BottomBarNavigationScreens(
            route = "search",
            title = "Search",
            icon = Icons.Filled.Search
        )

        object Favorites : BottomBarNavigationScreens(
            route = "favorites",
            title = "Favorites",
            icon = Icons.Filled.Favorite
        )
    }

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/{$it}")
            }
        }
    }
}