package com.example.tazakhabar.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tazakhabar.ui.theme.TazaKhabarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TazaKhabarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsApp()
                }
            }
        }
    }
}

@Composable
fun NewsApp() {
    Text(text = "Taza Khabar - Fresh News")
}

@Preview(showBackground = true)
@Composable
fun NewsAppPreview() {
    TazaKhabarTheme {
        NewsApp()
    }
}