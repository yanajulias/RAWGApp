package kompas.technical.test.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kompas.technical.test.features.ui.theme.RAWGAppTheme

@Composable
fun CardItemShimmer(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(
                MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.1f)
            )
    ) {
        Row {
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .background(
                        MaterialTheme.colorScheme.primary.copy(
                            alpha = 0.3f
                        )
                    )
            )

            Column(
                modifier = Modifier.height(100.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .height(20.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(4.dp))
                        .background(
                            MaterialTheme.colorScheme.primary.copy(
                                alpha = 0.1f
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .height(16.dp)
                        .fillMaxWidth(0.3f)
                        .clip(shape = RoundedCornerShape(4.dp))
                        .background(
                            MaterialTheme.colorScheme.primary.copy(
                                alpha = 0.1f
                            )
                        )
                )

                Box(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .height(12.dp)
                        .fillMaxWidth(0.7f)
                        .clip(shape = RoundedCornerShape(4.dp))
                        .background(
                            MaterialTheme.colorScheme.primary.copy(
                                alpha = 0.1f
                            )
                        )
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CardItemShimmerPreview() {
    RAWGAppTheme {
        CardItemShimmer()
    }
}