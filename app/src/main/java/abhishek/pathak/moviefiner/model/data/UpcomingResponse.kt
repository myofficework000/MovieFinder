package abhishek.pathak.moviefiner.model.data

data class UpcomingResponse(
    val dates: DateRange,
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)