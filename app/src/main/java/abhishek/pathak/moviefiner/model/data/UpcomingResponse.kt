package abhishek.pathak.moviefiner.model.data

import com.google.gson.annotations.SerializedName

/**
 * Data class representing the response for upcoming movies.
 * @property dates The date range for the movies.
 * @property page The page number of the response.
 * @property results The list of upcoming movies.
 * @property totalPages The total number of pages available.
 * @property totalResults The total number of movies available.
 */
data class UpcomingResponse(
    @SerializedName("dates") val dates: DateRange,
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<Movie>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)
