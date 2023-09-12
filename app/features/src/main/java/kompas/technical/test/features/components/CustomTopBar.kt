package kompas.technical.test.features.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import kompas.technical.test.features.ui.theme.RAWGAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    title: String
) {
    TopAppBar(title = {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
        }
    })
}

@Preview(showBackground = true)
@Composable
fun CustomTopBarPreview() {
    RAWGAppTheme {
        CustomTopBar("Test title")
    }
}