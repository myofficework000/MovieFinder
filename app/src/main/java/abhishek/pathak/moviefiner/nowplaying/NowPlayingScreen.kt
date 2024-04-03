package abhishek.pathak.moviefiner.nowplaying

import abhishek.pathak.moviefiner.R
import abhishek.pathak.moviefiner.popular.NavigationItem
import abhishek.pathak.moviefiner.ui.theme.White
import abhishek.pathak.moviefiner.ui.theme.dp_10
import abhishek.pathak.moviefiner.ui.theme.dp_172
import abhishek.pathak.moviefiner.ui.theme.dp_200
import abhishek.pathak.moviefiner.ui.theme.dp_32
import abhishek.pathak.moviefiner.ui.theme.dp_4
import abhishek.pathak.moviefiner.ui.theme.dp_6
import abhishek.pathak.moviefiner.ui.theme.dp_60
import abhishek.pathak.moviefiner.ui.theme.sp_12
import abhishek.pathak.moviefiner.ui.theme.sp_14
import abhishek.pathak.moviefiner.ui.theme.sp_16
import abhishek.pathak.moviefiner.ui.theme.sp_20
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun NowPlayingScreen(nowPlayingMovieViewModel: NowPlayingMovieViewModel = viewModel(), navController: NavController) {
    nowPlayingMovieViewModel.fetchNowPlayingMovieData()
    val movieImage = nowPlayingMovieViewModel.nowPlayingLiveData.observeAsState()



    Column(modifier = Modifier
        .fillMaxWidth()
        .background(White)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = White),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = stringResource(id = R.string.NowPlaying),
                fontWeight = FontWeight.Bold,
                fontSize = sp_20,
                modifier = Modifier
                    .align(Alignment.Top)
            )

            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Row(modifier = Modifier.align(Alignment.TopEnd)) {
                    Text(
                        text = stringResource(id = R.string.view_details),
                        fontSize = sp_16,
                        modifier = Modifier,
                        color = Color.Gray
                    )

                    IconButton(
                        onClick = { navController.navigate(NavigationItem.NOW_PLAYING_DETAILS.route)},
                        modifier = Modifier.size(dp_32)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_right_24),
                            contentDescription = null
                        )
                    }
                }
            }
        }
        nowPlayingMovieViewModel.fetchNowPlayingMovieData()
        val response=nowPlayingMovieViewModel.nowPlayingLiveData.observeAsState()
        val nowPlayingResponse=response.value
        LazyHorizontalGrid(
            GridCells.Fixed(1),
            modifier = Modifier
                .background(White)
        ) {
            val list = movieImage.value?.results
            if(list!=null){

                items(nowPlayingResponse?.results ?: emptyList()){ result->
                    Box(modifier = Modifier.size(height = dp_60, width = dp_172)) {
                        ItemNowScreenList(result, navController)
                    }
                }
            }
            else{
                Log.e("error",list.toString())
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemNowScreenList(result : Result,navController: NavController) {
    Card(
        modifier = Modifier
            .padding(dp_10)
            .size(dp_200),
        elevation = CardDefaults.cardElevation(dp_4),
        onClick = {
            val route = "DETAILS_SCREEN/${result.id}"
            navController.navigate(route)}
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
fun NowPlayingScreenPrev() {
    NowPlayingScreen(nowPlayingMovieViewModel = NowPlayingMovieViewModel(),
        rememberNavController())
}
