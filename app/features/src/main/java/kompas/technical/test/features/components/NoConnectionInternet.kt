package kompas.technical.test.features.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kompas.technical.test.features.R
import kompas.technical.test.features.ui.theme.RAWGAppTheme

@Composable
fun NoConnectionScreen(
    onTryAgain: (() -> Unit)? = null,
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_no_connection),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Tidak ada koneksi internet",
                style = MaterialTheme.typography.titleSmall
            )
            if (onTryAgain != null) {
                Spacer(modifier = Modifier.height(12.dp))
                TextButton(onClick = onTryAgain) {
                    Text(text = "Coba Lagi")
                }
            }
        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun DefaultPreview() {
    RAWGAppTheme {
        NoConnectionScreen()
    }
}