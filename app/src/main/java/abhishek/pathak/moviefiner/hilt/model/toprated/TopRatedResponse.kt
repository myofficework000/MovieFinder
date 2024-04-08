package abhishek.pathak.moviefiner.hilt.model.toprated

import abhishek.pathak.moviefiner.hilt.model.local.Result

data class TopRatedResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)