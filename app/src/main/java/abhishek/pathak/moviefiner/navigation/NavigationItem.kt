package abhishek.pathak.moviefiner.navigation

sealed class NavigationItem(val route: String) {
    data object Welcome_Screen: NavigationItem(Screens.WELCOME_SCREEN.name)
    data object Popular_Screen: NavigationItem(Screens.POPULAR_SCREEN.name)
    data object Trending_Screen: NavigationItem(Screens.TRENDING_SCREEN.name)
    data object Movie_Detail_Screen: NavigationItem(Screens.MOVIE_DETAIL_SCREEN.name)
}