//package abhishek.pathak.moviefiner.view.screens
//
//import abhishek.pathak.moviefiner.R
//import abhishek.pathak.moviefiner.ui.theme.dp_8
//import abhishek.pathak.moviefiner.ui.theme.sp_20
//import abhishek.pathak.moviefiner.viewmodel.HiltMovieViewModel
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.constraintlayout.compose.ConstraintLayout
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//
//
//@Preview
//@Composable
//private fun TrendingScreenUIPrev() {
//    TrendingScreenUI(/*hiltViewModel(),*/
//        rememberNavController())
//}
//
//@Composable
//fun TrendingScreenUI(/*movieViewModel: HiltMovieViewModel = hiltViewModel(),*/
//                     navController: NavController) {
//
////    movieViewModel.getTrendingMovies()
////    val movies = movieViewModel.trendingMovie.observeAsState()
//
//    ConstraintLayout(modifier = Modifier
//        .fillMaxSize()
//        .padding(dp_8)) {
//
//        val (btnBack, title, gridList) = createRefs()
//
//        IconButton(onClick = { /*TODO*/ },
//            modifier = Modifier.constrainAs(btnBack){
//                top.linkTo(parent.top)
//                start.linkTo(parent.start)
//            }) {
//            Image(painter = painterResource(id = R.drawable.baseline_arrow_back_24),
//                contentDescription = null)
//        }
//
//        Text(text = "Trending",
//            fontSize = sp_20,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier
//                .constrainAs(title) {
//                    top.linkTo(parent.top)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                }
//                .padding(dp_8))
//
//        val gridColumn = 3
//
//        LazyVerticalGrid(
//            GridCells.Fixed(gridColumn),
//            modifier = Modifier
//                .constrainAs(gridList) {
//                    top.linkTo(title.bottom)
//                }
//                .fillMaxWidth())
//        {
////            movies.value?.let { it ->
////                items(it.movies){
////                    MovieItemUI(movie = it, rememberNavController())
////                }
////            }
//
//            items(movieList){
//                MovieItemUI(it, rememberNavController())
//            }
//
//        }
//    }
//}
