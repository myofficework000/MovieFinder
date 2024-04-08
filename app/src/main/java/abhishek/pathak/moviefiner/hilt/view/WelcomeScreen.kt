package abhishek.pathak.moviefiner.hilt.view


import abhishek.pathak.moviefiner.R
import abhishek.pathak.moviefiner.hilt.view.screens.FavScreen
import abhishek.pathak.moviefiner.hilt.view.screens.welcomescreens.NowPlayingUIWelcome
import abhishek.pathak.moviefiner.hilt.view.screens.welcomescreens.PopularUIWelcome
import abhishek.pathak.moviefiner.hilt.view.screens.welcomescreens.TopRatedUIWelcome
import abhishek.pathak.moviefiner.hilt.view.screens.welcomescreens.UpcomingUIWelcome
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MakeScafoldUI() {
    val navController=rememberNavController()
    Scaffold(topBar={}, bottomBar ={MyBottomBarUI(navController=navController)}) {
        NavHost(navController = navController, startDestination = BottomRoutes.Screen1.route,modifier=Modifier.padding(it)) {
            composable(BottomRoutes.Screen1.route){
                WelcomeScreen(navController = navController)
            }
            composable(BottomRoutes.Screen2.route){
                FavScreen(rememberNavController(), hiltViewModel())
            }
            composable(BottomRoutes.Screen3.route){

            }
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White)
        ) {
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
            ) {
                PopularUIWelcome(hiltViewModel(), navController)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
            ) {
                NowPlayingUIWelcome(hiltViewModel(), navController)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
            ) {
                UpcomingUIWelcome(hiltViewModel(), navController)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
            ) {
                TopRatedUIWelcome(hiltViewModel(), navController)
            }
        }
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

data class Movie(val imageResourceId: Int, val title: String)

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    MakeScafoldUI()
}