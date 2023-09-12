package kompas.technical.test.features.gamedetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kompas.technical.test.domain.model.Genre
import kompas.technical.test.features.ui.theme.RAWGAppTheme

@Composable
fun GameGenreListItem(
    modifier: Modifier = Modifier,
    genre: Genre
) {

    Column(
        modifier = Modifier
            .clipToBounds()
            .padding(top = 4.dp, bottom = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = modifier.width(90.dp),
            text = genre.name,
            style = MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold
            ),
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GameGenreListItemPreview() {
   RAWGAppTheme {

   }
}