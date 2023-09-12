package kompas.technical.test.features

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kompas.technical.test.features.favorites.FavoriteScreen
import kompas.technical.test.features.gamedetail.GameDetailScreen
import kompas.technical.test.features.home.HomeScreen
import kompas.technical.test.features.search.SearchScreen

@Composable
fun Navigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.BottomBarNavigationScreens.Home.route
    ) {
        composable(Screens.BottomBarNavigationScreens.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screens.BottomBarNavigationScreens.Search.route) {
            SearchScreen(navController = navController)
        }

        composable(Screens.BottomBarNavigationScreens.Favorites.route) {
            FavoriteScreen(navController = navController)
        }

        composable(
            Screens.GameDetailsScreen.withArgs("gameId"),
            arguments = Screens.GameDetailsScreen.arguments!!,
        ) {
            GameDetailScreen(
                navController = navController,
                gameId = it.arguments?.getInt("gameId") ?: 0,
            )
        }
    }
}