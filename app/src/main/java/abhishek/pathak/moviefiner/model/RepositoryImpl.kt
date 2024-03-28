package abhishek.pathak.moviefiner.model

import abhishek.pathak.moviefiner.model.data.UpcomingResponse

class RepositoryImpl(private val apiService: ApiService) : Repository {

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
}