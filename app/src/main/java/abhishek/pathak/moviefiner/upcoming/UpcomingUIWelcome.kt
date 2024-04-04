package abhishek.pathak.moviefiner.upcoming

import abhishek.pathak.moviefiner.R
import abhishek.pathak.moviefiner.ui.theme.White
import abhishek.pathak.moviefiner.ui.theme.dp_172
import abhishek.pathak.moviefiner.ui.theme.dp_32
import abhishek.pathak.moviefiner.ui.theme.dp_60
import abhishek.pathak.moviefiner.ui.theme.sp_16
import abhishek.pathak.moviefiner.ui.theme.sp_20
import abhishek.pathak.moviefiner.view.screens.ItemView
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun UpcomingUIWelcome(
    upcomingViewModel: UpcomingViewModel = viewModel(),
    navController: NavController
) {
    upcomingViewModel.fetchUpcomingMovieData()
    val movieImage = upcomingViewModel.upcomingLiveData.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = White),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = stringResource(id = R.string.upcoming),
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
                        text = stringResource(id = R.string.view_all),
                        fontSize = sp_16,
                        modifier = Modifier,
                        color = Color.Gray
                    )

                    IconButton(
                        onClick = { /* navigate to the upcoming list screen */ },
                        modifier = Modifier.size(dp_32)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_right_24),
                            contentDescription = stringResource(id = R.string.cd_view_all)
                        )
                    }
                }
            }
        }
        LazyHorizontalGrid(
            GridCells.Fixed(1),
            modifier = Modifier
                .background(White)
        ) {
            val list = movieImage.value?.results
            if (list != null) {
                items(list.size) { item ->
                    Box(modifier = Modifier.size(height = dp_60, width = dp_172)) {
                        ItemView(
                            "${ConstantsUpcoming.IMAGE_ENDPOINT + list[item].posterPath}",
                            list[item].title,
                            list[item].releaseDate
                        )
                    }
                }
            } else {
                Log.e("error", "Error fetching upcoming movies.")
            }
        }
    }
}

@Preview
@Composable
fun UpcomingUIWelcomePrev() {
    UpcomingUIWelcome(upcomingViewModel = UpcomingViewModel(), rememberNavController())
}