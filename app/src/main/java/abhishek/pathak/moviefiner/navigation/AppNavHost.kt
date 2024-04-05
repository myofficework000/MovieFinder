package abhishek.pathak.moviefiner.navigation

import abhishek.pathak.moviefiner.model.movie_detail.MovieDetailsScreen
import abhishek.pathak.moviefiner.model.top_rated.TopRatedList
import abhishek.pathak.moviefiner.model.top_rated.TopRatedViewModel
import abhishek.pathak.moviefiner.model.upcoming.UpcomingListUi
import abhishek.pathak.moviefiner.model.upcoming.UpcomingViewModel
import abhishek.pathak.moviefiner.nowplaying.NowPlayingList
import abhishek.pathak.moviefiner.nowplaying.NowPlayingMovieViewModel
import abhishek.pathak.moviefiner.popular.PopularScreenUI
import abhishek.pathak.moviefiner.popular.PopularViewModel
import abhishek.pathak.moviefiner.ui.view.WelcomeScreen
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
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.WELCOME.route) {
            WelcomeScreen(navHostController)
        }
        composable(NavigationItem.LISTSCREEN.route) {
            PopularScreenUI(popularViewModel = PopularViewModel(), navHostController)
        }

        composable(NavigationItem.NOW_PLAYING_DETAILS.route) {
            NowPlayingList(NowPlayingMovieViewModel(),navHostController)
        }
        composable(NavigationItem.UPCOMING_LIST.route) {
            UpcomingListUi(UpcomingViewModel(),navHostController)
        }
        composable(NavigationItem.TOPRATED_LIST.route) {
            TopRatedList(TopRatedViewModel(),navHostController)
        }
        composable(
            "DETAILS_SCREEN/{movie_id}",
            arguments = listOf(navArgument(name = "movie_id") { // Notice over here
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movie_id")
            if (movieId != null) {
                MovieDetailsScreen(navHostController, movieId)
            }
        }
    }
}