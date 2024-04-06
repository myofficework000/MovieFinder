package abhishek.pathak.moviefiner.model.top_rated

data class TopRatedResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)