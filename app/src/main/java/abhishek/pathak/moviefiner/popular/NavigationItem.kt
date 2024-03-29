package abhishek.pathak.moviefiner.popular

sealed class NavigationItem(val route: String) {
    data object WELCOME : NavigationItem(Screen.WELCOME.name)
    data object LISTSCREEN : NavigationItem(Screen.LISTSCREEN.name)
    data object DETAILSSCREEN : NavigationItem(Screen.DETAILSSCREEN.name)
}