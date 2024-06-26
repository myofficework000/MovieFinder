package abhishek.pathak.moviefiner.hilt.view.screens.welcomescreens


import abhishek.pathak.moviefiner.R
import abhishek.pathak.moviefiner.hilt.model.Constants.IMAGE_ENDPOINT
import abhishek.pathak.moviefiner.hilt.view.screens.ItemView
import abhishek.pathak.moviefiner.hilt.viewmodel.MovieListsViewModel
import abhishek.pathak.moviefiner.navigation.NavigationItem
import abhishek.pathak.moviefiner.ui.theme.White
import abhishek.pathak.moviefiner.ui.theme.dp_172
import abhishek.pathak.moviefiner.ui.theme.dp_60
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun NowPlayingUIWelcome(
    nowPlayingViewModel: MovieListsViewModel = hiltViewModel(),
    navController: NavController
) {
    nowPlayingViewModel.fetchNowPlayingMovieDetails()
    val movieImage = nowPlayingViewModel.nowplayingLiveData.observeAsState()
    val errorData = nowPlayingViewModel.nowplayingErrorData.observeAsState()

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(White)
    ) {

        ViewDetailsActionUI(
            navController,
            stringResource(id = R.string.NowPlaying),
            NavigationItem.NOWPLAYINGLISTSCREEN.route
        )

        LazyHorizontalGrid(
            GridCells.Fixed(1),
            modifier = Modifier
                .background(White)
        ) {
            val list = movieImage.value?.results
            if (list != null) {
                items(list.size) { item ->
                    Box(modifier = Modifier.size(height = dp_60, width = dp_172)) {
                        val data = list[item]
                        ItemView(
                            "${IMAGE_ENDPOINT + list[item].posterPath}.toString()",
                            data.title,
                            data.releaseDate,
                            navController,
                            movieId = data.id.toString(),
                            data
                        )
                    }
                }
            } else {
                Log.e("error", errorData.value.toString())
            }
        }
    }
}
