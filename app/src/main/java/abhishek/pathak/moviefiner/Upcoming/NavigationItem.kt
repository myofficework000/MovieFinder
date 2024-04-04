package abhishek.pathak.moviefiner.Upcoming

sealed class NavigationItem(val route: String) {
    object WELCOME : NavigationItem("welcome")
    object LISTSCREEN : NavigationItem("listScreen")
    object DETAILSSCREEN : NavigationItem("detailsScreen")
    object UPCOMINGSCREEN : NavigationItem("upcomingScreen")
}