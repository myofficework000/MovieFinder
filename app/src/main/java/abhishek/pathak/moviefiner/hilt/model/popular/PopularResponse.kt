package abhishek.pathak.moviefiner.hilt.model.popular

import abhishek.pathak.moviefiner.hilt.model.local.Result

data class PopularResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)