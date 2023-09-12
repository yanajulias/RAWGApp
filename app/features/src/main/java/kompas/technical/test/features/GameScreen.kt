package kompas.technical.test.features

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kompas.technical.test.features.ui.theme.RAWGAppTheme

@Composable
fun GameScreen() {
    val navController: NavController = rememberNavController()

    RAWGAppTheme(darkTheme = isSystemInDarkTheme()) {
        Navigation(
            navController = navController as NavHostController,
        )
    }
}
