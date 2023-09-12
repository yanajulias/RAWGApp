package kompas.technical.test.features.gamedetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kompas.technical.test.domain.model.GameDetail
import kompas.technical.test.features.R
import kompas.technical.test.features.ui.theme.RAWGAppTheme

@Composable
fun GameDetailsHeader(
    modifier: Modifier = Modifier,
    gameDetails: GameDetail
) {
    val context = LocalContext.current

    Column {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(gameDetails.backgroundImage)
                .crossfade(true).build(),
            placeholder = painterResource(id = R.drawable.ic_placeholder),
            error = painterResource(id = R.drawable.ic_placeholder),
            contentDescription = "Image Detail",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .height(300.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
        )

        Column {
            Text(
                modifier = modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                text = gameDetails.name,
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                modifier = modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                text = "Release Date : ${gameDetails.released}",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    fontWeight = FontWeight.ExtraBold
                ),
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GameDetailsHeaderPreview() {
    RAWGAppTheme {
        //GameDetailsHeader()
    }
}