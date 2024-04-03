package abhishek.pathak.moviefiner.popular

import abhishek.pathak.moviefiner.model.Details.MovieDetailsScreen
import abhishek.pathak.moviefiner.nowplaying.NowPlayingList
import abhishek.pathak.moviefiner.nowplaying.NowPlayingMovieViewModel
import abhishek.pathak.moviefiner.ui.view.WelcomeScreen
import abhishek.pathak.moviefiner.view.screens.PopularScreenUI
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String = NavigationItem.WELCOME.route
)  {  NavHost(
    modifier = modifier,
    navController = navHostController,
    startDestination = startDestination){
        composable(NavigationItem.WELCOME.route) {
            WelcomeScreen(navHostController)
        }
        composable(NavigationItem.LISTSCREEN.route) {
            PopularScreenUI(popularViewModel = PopularViewModel(),navHostController)
        }

        composable(NavigationItem.NOW_PLAYING_DETAILS.route) {
            NowPlayingList(navHostController, NowPlayingMovieViewModel())
        }
        composable("DETAILS_SCREEN/{movie_id}", arguments = listOf(navArgument(name = "movie_id"){ // Notice over here
            type = NavType.StringType
        })) { backStackEntry->
            val movieId=backStackEntry.arguments?.getString("movie_id")
            if(movieId!=null){
                MovieDetailsScreen(navHostController,movieId)
            }
        }


}
}