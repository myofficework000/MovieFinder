package abhishek.pathak.moviefiner.ui.view

import abhishek.pathak.moviefiner.R

sealed class HomeBottomNavigation(val title: String, val icon: Int, val route: String) {

    object Home : HomeBottomNavigation("Home", R.drawable.baseline_add_home_24, "home")
    object Favorite : HomeBottomNavigation("Favorite", R.drawable.baseline_favorite_24, "favorite")
    object Profile : HomeBottomNavigation("Profile", R.drawable.baseline_emoji_people_24, "profile")


}