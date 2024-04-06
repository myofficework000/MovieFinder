package abhishek.pathak.moviefiner.view.screens

import abhishek.pathak.moviefiner.R
import abhishek.pathak.moviefiner.ui.theme.LightGray20
import abhishek.pathak.moviefiner.ui.theme.dp_16
import abhishek.pathak.moviefiner.ui.theme.dp_8
import abhishek.pathak.moviefiner.ui.theme.sp_20
import abhishek.pathak.moviefiner.ui.theme.sp_30
import abhishek.pathak.moviefiner.viewmodel.HiltMovieViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
private fun TrendingUIPrev() {
    TrendingRowUI()
}

@Composable
fun TrendingRowUI(movieViewModel: HiltMovieViewModel = hiltViewModel()) {

    movieViewModel.getTrendingMovies()
    val responseMovie = movieViewModel.trendingMovie.observeAsState()

    ConstraintLayout(
        Modifier
            .fillMaxWidth()
            .padding(dp_8, dp_16)
    ) {
        val (title, btnViewAll) = createRefs()
        val (lazyRowTrendMovie) = createRefs()

        Text(text = "Trending",
            fontSize = sp_30,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })

        TextButton(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(btnViewAll) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }) {

            Text(
                text = "View all",
                fontSize = sp_20,
                color = LightGray20
            )

            Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_right_24),
                contentDescription = null
            )
        }

        LazyRow(modifier = Modifier.constrainAs(lazyRowTrendMovie) {
            start.linkTo(parent.start)
            top.linkTo(title.bottom)
        }) {

            responseMovie.value?.let { movieList ->
                movieList.movies?.let { movies ->
                    items(movies) {
                        MovieItemUI(movie = it, rememberNavController())
                    }
                }
            }

//            if(movies.value != null){
//                items(movies.value!!.movies){
//                    MovieItemUI(it, rememberNavController())
//package abhishek.pathak.moviefiner.view.screens
//
//import abhishek.pathak.moviefiner.R
//import abhishek.pathak.moviefiner.model.data.Movie
//import abhishek.pathak.moviefiner.ui.theme.LightGray20
//import abhishek.pathak.moviefiner.ui.theme.dp_16
//import abhishek.pathak.moviefiner.ui.theme.dp_20
//import abhishek.pathak.moviefiner.ui.theme.dp_4
//import abhishek.pathak.moviefiner.ui.theme.dp_8
//import abhishek.pathak.moviefiner.ui.theme.sp_10
//import abhishek.pathak.moviefiner.ui.theme.sp_20
//import abhishek.pathak.moviefiner.ui.theme.sp_30
//import abhishek.pathak.moviefiner.viewmodel.HiltMovieViewModel
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.constraintlayout.compose.ConstraintLayout
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
//import com.bumptech.glide.integration.compose.GlideImage
//
//@Preview
//@Composable
//private fun TrendingUIPrev() {
//    TrendingRowUI()
//}
//
//@Composable
//fun TrendingRowUI(movieViewModel: HiltMovieViewModel = hiltViewModel()) {
//
//    movieViewModel.getTrendingMovies()
//    val responseMovie = movieViewModel.trendingMovie.observeAsState()
//
//    ConstraintLayout (
//        Modifier
//            .fillMaxWidth()
//            .padding(dp_8, dp_16)){
//        val (title, btnViewAll) = createRefs()
//        val (lazyRowTrendMovie) = createRefs()
//
//        Text(text = "Trending",
//            fontSize = sp_30,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.constrainAs(title){
//                top.linkTo(parent.top)
//                start.linkTo(parent.start)
//            })
//
//        TextButton(onClick = { /*TODO*/ },
//            modifier = Modifier.constrainAs(btnViewAll){
//                top.linkTo(parent.top)
//                end.linkTo(parent.end)
//            }) {
//
//            Text(text = "View all",
//                fontSize = sp_20,
//                color = LightGray20)
//
//            Image(painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_right_24),
//                contentDescription = null)
//        }
//
//        LazyRow(modifier = Modifier.constrainAs(lazyRowTrendMovie){
//            start.linkTo(parent.start)
//            top.linkTo(title.bottom)
//        }) {
//
//            responseMovie.value?.let { movieList ->
//                movieList.movies?.let { movies ->
//                    items(movies){
//                        MovieItemUI(movie = it, rememberNavController())
//                    }
            >>>>>>> 810bd4a702df089b31471899b11d83aaa3046200
//                }
//            }
//
////            if(movies.value != null){
////                items(movies.value!!.movies){
////                    MovieItemUI(it, rememberNavController())
////                }
////            }
//
////            items(movieList){
////                    MovieItemUI(it, rememberNavController())
////                }
//
//        }
//
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
//@Composable
//fun MovieItemUI(movie: Movie, navController: NavController) {
//
//    Card(
//        onClick = { navController
//                .navigate("${NavigationItem.Movie_Detail_Screen.route}/${movie.id}")
//                  },
//        colors = CardDefaults.cardColors(
//            containerColor = Color.White,
//        ),
//        elevation = CardDefaults.cardElevation(dp_4),
//        modifier = Modifier
//            .width(140.dp)
//            .padding(dp_4, dp_20)) {
//
//        Column (
//            Modifier
//                .fillMaxWidth()
//                .padding(dp_4, dp_20)
//        ){
//
//        GlideImage(
//            model = {"https://image.tmdb.org/t/p/original/" + movie.posterPath},//image.tmdb.org/t/p/original/qrGtVFxaD8c7et0jUtaYhyTzzPg.jpg",
//            contentDescription = null)
//
//            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
//                contentDescription = null, modifier = Modifier.fillMaxWidth())
//
//            Text(
//                text = movie.title,
//                fontSize = sp_10,
//                fontWeight = FontWeight.Bold,
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis
//            )
//
//            Text(text = movie.releaseDate,
//                fontSize = sp_10)
//        }
//    }
//}
//
//@Preview
//@Composable
//private fun MovieItemUIPrev() {
//    MovieItemUI(movie, rememberNavController())
//}
//
//
//val movie = Movie(
//    false,
//    "/qrGtVFxaD8c7et0jUtaYhyTzzPg.jpg",
//    listOf<Int>(28,878,12),
//    823464,
//    "movie",
//    "en",
//    "Following their explosive showdown, Godzilla and Kong must reunite against a colossal undiscovered threat hidden within our world, challenging their very existence – and our own.",
//    1758.469,
//    "/lF9LNf420WMH81gG7sq6ioDOhtl.jpg",
//    "2024-03-27",
//    "Godzilla x Kong: The New Empire",
//    false,
//    7.758,
//    64
//    )
//
//val movieList = listOf(
//    movie, movie, movie,
//    movie, movie, movie,
//    movie, movie, movie,
//    movie, movie, movie,
//    movie, movie, movie,
//    movie, movie, movie)
