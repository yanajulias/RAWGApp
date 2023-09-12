package kompas.technical.test.features.gamedetail.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kompas.technical.test.domain.mapper.toGenre
import kompas.technical.test.frameworks.http.model.remote.GenreDto

@Composable
fun GameDetailsGenre(
    modifier: Modifier = Modifier,
    genres: List<GenreDto>,
) {
    if (genres.isEmpty()) return

    val scrollState: ScrollState = rememberScrollState()
    Column(modifier = modifier.padding(top = 12.dp)) {

        GameDetailsSection(title = "Genres")

        Row(
            modifier = modifier
                .horizontalScroll(scrollState)
                .padding(start = 12.dp, end = 12.dp)
        ) {
            genres.forEach { genre ->
                GameGenreListItem(
                    genre = genre.toGenre()
                )
            }
        }
    }


}