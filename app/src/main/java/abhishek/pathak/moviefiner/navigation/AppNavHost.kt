package abhishek.pathak.moviefiner.navigation

//import abhishek.pathak.moviefiner.ui.view.WelcomeScreen
import abhishek.pathak.moviefiner.popular.PopularViewModel
import abhishek.pathak.moviefiner.view.screens.MovieDetailsScreen
import abhishek.pathak.moviefiner.view.screens.PopularScreenUI
import abhishek.pathak.moviefiner.view.screens.TrendingScreenUI
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    startDestination: String = NavigationItem.Welcome_Screen.route
) {

    NavHost(navController = navHostController, startDestination = startDestination) {

//        composable(NavigationItem.Welcome_Screen.route){ WelcomeScreen(navHostController)}

        composable(NavigationItem.Popular_Screen.route){ PopularScreenUI(PopularViewModel(),navHostController)}

        composable(NavigationItem.Trending_Screen.route){ /*TrendingScreenUI(hiltViewModel(),*/ navHostController }

        composable("${NavigationItem.Movie_Detail_Screen.route}/{movieID}"){ backStackEntry ->
            MovieDetailsScreen(
                navHostController,
                backStackEntry.arguments?.getString("movieID")
            )
        }
    }
}