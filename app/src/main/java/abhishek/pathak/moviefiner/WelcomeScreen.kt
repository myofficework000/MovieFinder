package abhishek.pathak.moviefiner.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import abhishek.pathak.moviefiner.ui.view.components.*
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment


data class Movie(val posterUrl: String, val title: String, val releaseDate: String)

@Composable
fun WelcomeScreen(navController: NavController) {
    val popularMovies = remember { /* TODO: Fetch popular movies */ listOf<Movie>() }
    val nowPlayingMovies = remember { /* TODO: Fetch now playing movies*/ listOf<Movie>() }
    val topRatedMovies = remember { /* TODO: Fetch top rated movies*/ listOf<Movie>() }
    val upcomingMovies = remember { /* TODO: Fetch upcoming movies */ listOf<Movie>() }

    Scaffold(bottomBar = {
        BottomNavigationBar(navController = navController)
    }) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
        ) {
            item {
                WelcomeBanner()
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                MovieSection(
                    title = "Popular",
                    movies = popularMovies,
                    onViewAllClick = { /* TODO: Navigate to View All Popular Movies */ }
                )
            }
            item {
                MovieSection(
                    title = "Now Playing",
                    movies = nowPlayingMovies,
                    onViewAllClick = { /* TODO: Navigate to View All Now Playing Movies */ }
                )
            }
            item {
                MovieSection(
                    title = "Top Rated",
                    movies = topRatedMovies,
                    onViewAllClick = { /* TODO: Navigate to View All Top Rated Movies */ }
                )
            }
            item {
                MovieSection(
                    title = "Upcoming",
                    movies = upcomingMovies,
                    onViewAllClick = { /* TODO: Navigate to View All Upcoming Movies */ }
                )
            }
        }
    }
}

@Composable
fun WelcomeBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.WelcomeScreenBlue)
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Welcome",
                style = MaterialTheme.typography.h5,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Millions of movies, TV shows and people to discover. Explore now.",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar()
        }
    }
}

@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = { },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp)),
        placeholder = { Text(text = "Search for a movie...") }
    )
}

@Composable
fun MovieSection(
    title: String,
    movies: List<Movie>,
    onViewAllClick: () -> Unit
) {
    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        MovieSectionHeader(title, onViewAllClick)
        LazyRow(modifier = Modifier.padding(top = 8.dp)) {
            items(movies) { movie ->
                MovieCard(movie = movie)
            }
        }
    }
}

@Composable
fun MovieSectionHeader(
    title: String,
    onViewAllClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6
        )
        TextButton(onClick = onViewAllClick) {
            Text(text = "View All")
        }
    }
}

@Composable
fun MovieCard(movie: Movie) {
    // TODO: Movie Card
}