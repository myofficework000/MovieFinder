package abhishek.pathak.moviefiner.navigation

/**
 * Sealed class representing different navigation destinations in the application.
 * @property route The route associated with the navigation destination.
 */
sealed class NavigationItem(val route: String) {
    /** Represents the welcome screen. */
    data object WELCOME : NavigationItem(Screen.WELCOME.name)

    /** Represents the list screen. */
    data object LISTSCREEN : NavigationItem(Screen.LISTSCREEN.name)

    /** Represents the now playing details screen. */
    data object NOW_PLAYING_DETAILS : NavigationItem(Screen.NOW_PLAYING_DETAILS.name)

    /** Represents the upcoming list screen. */
    data object UPCOMING_LIST: NavigationItem(Screen.UPCOMING_LIST.name)

    /** Represents the top-rated list screen. */
    data object TOPRATED_LIST: NavigationItem(Screen.TOPRATED_LIST.name)

    /**
     * Represents the details screen for a specific movie.
     * @property movie_id The ID of the movie.
     */
    data class DETAILS_SCREEN(val movie_id: Int) :
        NavigationItem("${Screen.DETAILS_SCREEN.name}/$movie_id")
}
