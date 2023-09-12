package kompas.technical.test.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kompas.technical.test.features.ui.theme.RAWGAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           GameScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RAWGAppTheme {

    }
}