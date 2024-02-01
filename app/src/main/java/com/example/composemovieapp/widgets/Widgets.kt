package com.example.composemovieapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.composemovieapp.model.MovieList
import com.example.composemovieapp.model.getMovies

// passing a click listener to make each row clickable
@Preview
@Composable
fun MovieRow(movie: MovieList = getMovies()[0], onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onItemClick(movie.title) },
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
                Image(
                    painter = rememberImagePainter(data = movie.images),
                    contentDescription = "Images"
                )
            }
            Column(modifier = Modifier.padding(start = 12.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "Director: ${movie.director}",
                    style = MaterialTheme.typography.labelMedium
                )
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.labelMedium)
                Text(text = "Genre: ${movie.genre}", style = MaterialTheme.typography.labelMedium)
                Text(text = "Actors: ${movie.actors}", style = MaterialTheme.typography.labelMedium)
            }
        }
    }
}