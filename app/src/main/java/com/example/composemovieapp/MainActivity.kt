package com.example.composemovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composemovieapp.navigation.MovieNavigation
import com.example.composemovieapp.ui.theme.ComposeMovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation()
            }
        }
    }
}

//container function
@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposeMovieAppTheme {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp {
        MovieNavigation()
    }
}