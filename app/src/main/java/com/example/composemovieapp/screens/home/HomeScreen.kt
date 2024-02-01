package com.example.composemovieapp.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composemovieapp.navigation.MovieScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    /**
     * Scaffold - part of material design that implements the basic material design layout
     * structure.
     */
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = Color.Black
                ),
                title = {
                    Text(
                        text = "Compose Movie App",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            )
        },
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
        "Comedy",
        "Fantasy",
        "Crime",
        "Drama",
        "Music",
        "Adventure",
        "History",
        "Thriller",
        "Animation",
        "Family",
        "Comedy",
        "Fantasy",
        "Crime",
        "Drama",
        "Music",
        "Adventure",
        "History",
        "Thriller",
        "Animation",
        "Family"
    )
) {
    Column(modifier = Modifier.padding(top = 70.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    // passing movie name to detail screen
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                    Log.d("MOVIE", "Navigated to: $movie")
                }
            }
        }
    }
}

// passing a click listener to make each row clickable
@Composable
fun MovieRow(movie: String, onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onItemClick(movie) },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(95.dp),
                shape = RectangleShape,
                shadowElevation = 5.dp
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Person")
            }
            Text(text = movie)
        }
    }
}