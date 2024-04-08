package abhishek.pathak.moviefiner.hilt.model.nowplaying

data class NowplayingMovieResponse(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)