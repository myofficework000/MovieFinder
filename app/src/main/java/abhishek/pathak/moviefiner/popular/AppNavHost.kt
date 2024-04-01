package abhishek.pathak.moviefiner.popular

import abhishek.pathak.moviefiner.PopularScreenUI
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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
            val popularViewModel = PopularViewModel()
            popularUIWelcome(popularViewModel,navHostController)
        }
        composable(NavigationItem.LISTSCREEN.route) {
            PopularScreenUI(popularViewModel = PopularViewModel())
        }
}
}