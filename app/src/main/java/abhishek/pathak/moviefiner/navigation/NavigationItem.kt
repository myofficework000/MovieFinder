package abhishek.pathak.moviefiner.navigation

sealed class NavigationItem(val route: String) {
    data object WELCOME : NavigationItem(Screen.WELCOME.name)
    data object LISTSCREEN : NavigationItem(Screen.LISTSCREEN.name)
    data object NOW_PLAYING_DETAILS : NavigationItem(Screen.NOW_PLAYING_DETAILS.name)
    data class DETAILS_SCREEN(val movie_id: Int) :
        NavigationItem("${Screen.DETAILS_SCREEN.name}/$movie_id")
}