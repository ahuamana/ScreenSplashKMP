package com.ahuaman.screensplashkmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.ahuaman.screensplashkmp.Greeting
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var goToMain = false

        lifecycleScope.launch {
            // Simulate a long-running operation
            Thread.sleep(3000)
            goToMain = true
        }

        installSplashScreen().apply {
            setKeepOnScreenCondition { !goToMain }
        }
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    HomeScreen("Hello, PaparazziTeam!")
                }
            }
        }
    }
}

@Composable
fun HomeScreen(text: String) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = text)
    }

}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        HomeScreen("Hello, Android!")
    }
}
