package kompas.technical.test.features.components

import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kompas.technical.test.features.R
import kompas.technical.test.features.Screens
import kompas.technical.test.features.ui.theme.RAWGAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBarNavigation(
    navController: NavController
) {
    val screens: List<Screens.BottomBarNavigationScreens> = listOf(
        Screens.BottomBarNavigationScreens.Home,
        Screens.BottomBarNavigationScreens.Search,
        Screens.BottomBarNavigationScreens.Favorites,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomAppBar {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    if (navController.currentDestination?.route != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    BadgedBox(
                        badge = {}
                    ) {
                        if (screen == Screens.BottomBarNavigationScreens.Home) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_home),
                                contentDescription = screen.title,
                            )
                        } else {
                            Icon(
                                imageVector = screen.icon!!,
                                contentDescription = screen.title
                            )
                        }
                    }
                },
                label = {
                    Text(text = screen.title)
                }
            )
        }
    }
}

@Preview
@Composable
fun BottomBarNavigationPreview() {
    RAWGAppTheme {
        BottomBarNavigation(navController = rememberNavController())
    }
}