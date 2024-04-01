package abhishek.pathak.moviefiner.ui.view

import abhishek.pathak.moviefiner.popular.PopularViewModel
import abhishek.pathak.moviefiner.R
import abhishek.pathak.moviefiner.popular.popularUIWelcome
import abhishek.pathak.moviefiner.ui.theme.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun WelcomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(padding)
        ) {
            GreetingSection()
            SearchBar()
            popularUIWelcome(PopularViewModel(), navController)
//            MovieSection(sectionTitle = "Now Playing", movies = listOf(/* list of now playing movies */))
//            MovieSection(sectionTitle = "Upcoming", movies = listOf(/* list of popular movies */))
//            MovieSection(sectionTitle = "Top Rated", movies = listOf(/* list of popular movies */))
        }
    }
}

@Composable
fun GreetingSection() {
    Text(
        text = "Welcome",
        modifier = Modifier.padding(16.dp)
    )

}

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        placeholder = { Text("Search for a movie...") },
        singleLine = true,
        keyboardActions = KeyboardActions(
            onSearch = { /* handle search */ }
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        trailingIcon = {
            IconButton(onClick = { /* icon click */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_content_paste_search_24),
                    contentDescription = "Search"
                )
            }
        }
    )
}

@Composable
fun MovieSection(sectionTitle: String, movies: List<Movie>) {
    Column {
        Text(
            text = sectionTitle,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
        )
        LazyRow {
            items(movies) { movie ->
                MovieCard(movie = movie)
            }
        }

    }
}

@Composable
fun MovieCard(movie: Movie) {
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = movie.imageResourceId),
                contentDescription = movie.title,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Text(
                text = movie.title,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )

        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        contentColor = Color.Black
    ) {
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.baseline_add_home_24), contentDescription = "Home") },
            label = { Text("Home") },
            selected = true,
            onClick = { /* handle Home click */ }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.baseline_favorite_24), contentDescription = "Favorites") },
            label = { Text("Favorites") },
            selected = false,
            onClick = { /* handle Favorites click */ }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.baseline_emoji_people_24), contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = false,
            onClick = { /* handle Profile click */ }
        )
    }
}

data class Movie(val imageResourceId: Int, val title: String)

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(rememberNavController())
}