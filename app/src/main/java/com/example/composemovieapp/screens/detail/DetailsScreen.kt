package com.example.composemovieapp.screens.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.composemovieapp.MyApp

@Composable
fun DetailScreen(navController: NavController, movieData: String?) {
    Text(text = movieData.toString())
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    MyApp {}
}