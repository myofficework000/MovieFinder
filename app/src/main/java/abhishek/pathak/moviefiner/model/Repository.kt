package abhishek.pathak.moviefiner.model

import abhishek.pathak.moviefiner.model.data.TrendingResponse
import abhishek.pathak.moviefiner.model.data.UpcomingResponse
import retrofit2.Response

interface Repository {
    suspend fun getTrendingMovies(): Response<TrendingResponse>
    suspend fun getMovies(page: Int): UpcomingResponse
}