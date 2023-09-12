package kompas.technical.test.features.gamedetail.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun GameDetailsSection(
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .padding(top = 8.dp),
        text = title,
        style = MaterialTheme.typography.titleLarge.copy(
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.ExtraBold
        ),
    )
}