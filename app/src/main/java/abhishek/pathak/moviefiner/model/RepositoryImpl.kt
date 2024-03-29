package abhishek.pathak.moviefiner.model


import abhishek.pathak.moviefiner.model.data.TrendingResponse
import abhishek.pathak.moviefiner.model.data.UpcomingResponse
import retrofit2.Response

class RepositoryImpl(private val apiService: APIService) : Repository {

    override suspend fun getMovies(page: Int): UpcomingResponse {
        val response = apiService.getMovies(page)
        if (response.isSuccessful) {
            response.body()?.let {
                return it
            } ?: throw Exception("Response is null")
        } else {
            throw Exception("Failed to fetch movies: ${response.message()}")
        }
    }

    override suspend fun getTrendingMovies(): Response<TrendingResponse> {
        TODO("Not yet implemented")
    }
}