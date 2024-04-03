package abhishek.pathak.moviefiner.nowplaying

import abhishek.pathak.moviefiner.R
import abhishek.pathak.moviefiner.ui.theme.White
import abhishek.pathak.moviefiner.ui.theme.dp_10
import abhishek.pathak.moviefiner.ui.theme.dp_200
import abhishek.pathak.moviefiner.ui.theme.dp_4
import abhishek.pathak.moviefiner.ui.theme.dp_6
import abhishek.pathak.moviefiner.ui.theme.sp_12
import abhishek.pathak.moviefiner.ui.theme.sp_14
import abhishek.pathak.moviefiner.ui.theme.sp_20
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder

@Composable
fun NowPlayingList(navController: NavController,nowPlayingMovieViewModel: NowPlayingMovieViewModel= viewModel()) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(White)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = White)
        ) {
            IconButton(
                onClick = {navController.popBackStack()},
                Modifier.paint(painterResource(id = R.drawable.baseline_arrow_back_24))
            ) { }

            Text(
                text = stringResource(id = R.string.NowPlaying),
                fontWeight = FontWeight.Bold,
                fontSize = sp_20,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        val columns = 3
        nowPlayingMovieViewModel.fetchNowPlayingMovieData()
        val response=nowPlayingMovieViewModel.nowPlayingLiveData.observeAsState()
        val nowPlayingResponse=response.value
        LazyVerticalGrid(
            GridCells.Fixed(columns),
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
        ) {
            items(nowPlayingResponse?.results ?: emptyList()){result->
                ItemNowScreen(result, navController)
                }
            }
        }
    }




@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemNowScreen(result : Result,navController: NavController) {
    Card(
        modifier = Modifier
            .padding(dp_10)
            .size(dp_200),
        elevation = CardDefaults.cardElevation(dp_4)
    ){
        Box(
            Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ){
            Column {
                val url="${Constants.IMAGE_ENDPOINT}${result.poster_path}"
                GlideImage(model = url,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp),
                    contentDescription = null,
                    loading = placeholder(R.drawable.ic_launcher_background))
                Text(text = result.title,
                    fontSize = sp_14,
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(dp_6),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
                Text(text = result.release_date,
                    fontSize = sp_12,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun NowPlayingListPrev() {
    val viewModel = remember { NowPlayingMovieViewModel() }

    // Call fetchUpcomingMovieData() to fetch now-playing movie data
    viewModel.fetchNowPlayingMovieData()

    // Pass the view model to the NowplayingList composable function
    NowPlayingList(rememberNavController(),nowPlayingMovieViewModel = viewModel)
}