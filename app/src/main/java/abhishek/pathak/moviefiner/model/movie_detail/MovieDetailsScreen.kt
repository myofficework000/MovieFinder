package abhishek.pathak.moviefiner.model.movie_detail

import abhishek.pathak.moviefiner.R
import abhishek.pathak.moviefiner.hilt.viewmodel.MovieListsViewModel
import abhishek.pathak.moviefiner.ui.theme.dp_10
import abhishek.pathak.moviefiner.ui.theme.dp_100
import abhishek.pathak.moviefiner.ui.theme.dp_120
import abhishek.pathak.moviefiner.ui.theme.dp_20
import abhishek.pathak.moviefiner.ui.theme.dp_30
import abhishek.pathak.moviefiner.ui.theme.dp_5
import abhishek.pathak.moviefiner.ui.theme.dp_50
import abhishek.pathak.moviefiner.ui.theme.sp_12
import abhishek.pathak.moviefiner.ui.theme.sp_14
import abhishek.pathak.moviefiner.ui.theme.sp_15
import abhishek.pathak.moviefiner.ui.theme.sp_20
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MovieDetailsScreen(navController: NavController, movieID: String?,detailsViewModel: MovieListsViewModel= hiltViewModel()) {
    val movieID="823464"
    detailsViewModel.fetchMovieDetails("823464")
    val movieImage =detailsViewModel.detailsLiveData.observeAsState()
    val errorData =detailsViewModel.detailsErrorData.observeAsState()
    val basicDetails=movieImage.value

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Row(
            modifier = Modifier.align(Alignment.Start)
        ){
            ImageButton(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = stringResource(id = R.string.Button_description),
                onClick = { /* Handle button click */ },
                modifier = Modifier.padding(top= dp_10, bottom = dp_10))
            Text(
                text = basicDetails!!.title,
                fontSize = sp_20,
                color = Color.Black,
                modifier = Modifier
                    .padding(dp_10)
                    .align(Alignment.CenterVertically)
            )}
            Box() {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(dp_20)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dp_120)
                        .padding(start = dp_10, top = dp_20, bottom = dp_10)
                        .align(Alignment.CenterStart)
                )
            }
            Text(
                text =basicDetails!!.original_language ,
                fontSize = sp_20,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = dp_10
                    , start = dp_10, end = dp_10)
            )
            Text(
                text = stringResource(id = R.string.description1),
                fontSize = sp_15
            )
            Text(
                text = stringResource(id = R.string.Genre),
                fontSize = sp_12,
                color = Color.Gray
            )
            Row(modifier = Modifier.padding(dp_30)) {
                Text(
                    text = stringResource(id = R.string.user_Score),
                    fontSize = sp_14,
                    color = Color.Black
                )
                Text(
                    text = "|",
                    fontSize = sp_14,
                    color = Color.Black
                )
                Text(
                    text = stringResource(id = R.string.Play_trailer),
                    fontSize = sp_14,
                    color = Color.Black
                )
            }
            Text(
                text = stringResource(id = R.string.Overview),
                fontSize = sp_20,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = dp_10)
            )
            Text(
                text = stringResource(id = R.string.description),
                fontSize = sp_14,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(dp_10)
            )
            Text(
                text = stringResource(id = R.string.Cast_bill),
                fontSize = sp_20,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(dp_10)
            )
            CastList()
        }
}

data class TopBilledCastList(val img: Int, val name: String)

val listCast= listOf(
    TopBilledCastList(R.drawable.ic_launcher_background, "Sam Worthington"),
    TopBilledCastList(R.drawable.ic_launcher_background, "Zoe Saldana"),
    TopBilledCastList(R.drawable.ic_launcher_background, "Dallas Liu"),
    TopBilledCastList(R.drawable.ic_launcher_background, "Stephen Lang")
)

@Composable
fun CastList(){
    LazyRow{
        items(listCast){
           ItemTopBilledCast(it)
        }
    }
}
@Composable
fun ImageButton(
    painter: Painter,
    contentDescription: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        modifier = modifier
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(dp_50)
                .wrapContentSize() // To match the size of the image
        )
    }
}
@Composable
fun ItemTopBilledCast(topBilledCastList: TopBilledCastList){
    Row{
        Column(modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,) {
           Image(painter = painterResource(id = topBilledCastList.img), contentDescription =null,
               modifier = Modifier
                   .size(dp_100)
                   .padding(dp_10))
            Text(text = topBilledCastList.name,
                fontSize = sp_14,
                modifier = Modifier.padding(dp_5))
        }
    }
}
@Preview
@Composable
fun Prev(){
    MovieDetailsScreen(rememberNavController(), "12345678")
}