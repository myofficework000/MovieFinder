package abhishek.pathak.moviefiner.model

object Constants {
    const val BASE_URL = "https://api.example.com/"
    const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"
}

fun getFullImageUrl(posterPath: String?): String {
    return "${Constants.IMAGE_BASE_URL}$posterPath"
}
