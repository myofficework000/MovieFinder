package abhishek.pathak.moviefiner.model.data

data class TrendingResponse(
    val page: Int,
    val movies: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)