package abhishek.pathak.moviefiner.hilt.view.screens

import abhishek.pathak.moviefiner.R
import abhishek.pathak.moviefiner.hilt.model.Constants.IMAGE_ENDPOINT
import abhishek.pathak.moviefiner.hilt.viewmodel.FavouritesMovieViewModel
import abhishek.pathak.moviefiner.ui.theme.White
import abhishek.pathak.moviefiner.ui.theme.dp_10
import abhishek.pathak.moviefiner.ui.theme.sp_20
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun FavScreen(navController: NavController, favouritesMovieViewModel: FavouritesMovieViewModel = hiltViewModel()) {
    val movieImageState = favouritesMovieViewModel.favMovies.observeAsState()
    val movieImage = movieImageState.value


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = White),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.favourites),
            fontWeight = FontWeight.Bold,
            fontSize = sp_20,
            modifier = Modifier
                .align(Alignment.CenterHorizontally).padding(dp_10)
        )

        LazyVerticalGrid(
            GridCells.Fixed(2),
            modifier = Modifier
                .wrapContentWidth()
                .background(White)
        ) {
            val list = movieImage
            if (list != null) {
                items(list.size) { item ->
                    Box(modifier = Modifier.fillMaxWidth()) {
                        val data = list[item]
                        ItemView(
                            "${IMAGE_ENDPOINT + list[item].posterPath}.toString()",
                            data.title,
                            data.releaseDate,
                            navController,
                            movieId = data.id.toString(),
                            data = data
                        )
                    }
                }
            } else {
                Log.e("error", list.toString())
            }
        }
    }
}

@Preview
@Composable
private fun FavoriteScreenPrev() {
    FavScreen(rememberNavController())
}