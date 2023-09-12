package kompas.technical.test.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kompas.technical.test.domain.model.Game
import kompas.technical.test.features.R
import kompas.technical.test.features.Screens
import kompas.technical.test.features.ui.theme.RAWGAppTheme

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    gameList: Game,
) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.tertiary.copy(alpha = 0.1f))
            .clickable {
                val route = Screens.GameDetailsScreen.route + "/${gameList.id}"
                println("route: $route")
                navController?.navigate(route)
            }
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(gameList.backgroundImage)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = R.drawable.ic_placeholder),
                error = painterResource(id = R.drawable.ic_placeholder),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )

            Column(
                modifier = modifier.padding(bottom = 14.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    modifier = Modifier.padding(
                        horizontal = 12.dp,
                        vertical = 4.dp
                    ).padding(top = 8.dp, bottom = 4.dp),
                    text = gameList.name,
                    style = MaterialTheme.typography.titleLarge.copy(
                        MaterialTheme.colorScheme.onSecondaryContainer,
                        fontWeight = FontWeight.ExtraBold
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    modifier = Modifier
                        .padding(
                            horizontal = 12.dp,
                        )
                        .padding(top = 8.dp, bottom = 4.dp),
                    text = "Released: ${gameList.released}",
                    style = MaterialTheme.typography.labelLarge.copy(
                        MaterialTheme.colorScheme.onSecondaryContainer,
                        fontWeight = FontWeight.SemiBold
                    ),
                    overflow = TextOverflow.Ellipsis
                )

                gameList.genres.joinToString(", ") { it.name }.let {
                    Text(
                        modifier = modifier.padding(
                            horizontal = 12.dp,
                        ),

                        text = "Genre: $it",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun CardItemPreview() {
    RAWGAppTheme {
//        CardItem()
    }
}